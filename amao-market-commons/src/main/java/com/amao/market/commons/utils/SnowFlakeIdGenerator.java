package com.amao.market.commons.utils;

import com.amao.market.commons.interfaces.IdGenerator;

/**
 * 雪花算法ID生成器
 *
 * @author LinYuchang
 * @since 1.0.0
 */
public class SnowFlakeIdGenerator implements IdGenerator {

    // 毫秒级时间戳占用 42 位
    protected static final int DEFAULT_TIMESTAMP_BIT_COUNT = 42;
    // 最高位是符号位，不可用，所以减 1 位
    protected static final int DEFAULT_TIMESTAMP_BIT_OFFSET = Long.SIZE - 1 - DEFAULT_TIMESTAMP_BIT_COUNT;

    protected long lastTimestamp;
    protected int maxSequence;

    protected int machineId;
    protected int sequence;

    protected int timestampBitLeftOffset;
    protected int machineIdBitLeftOffset;


    /**
     * 创建ID生成器
     *
     * @param machineCount 集群中的主机数量
     * @param machineId    当前主机的编号，从 0 开始
     * @return ID生成器实例对象
     */
    public static SnowFlakeIdGenerator newInstance(int machineCount, int machineId) {
        return new SnowFlakeIdGenerator(machineCount, machineId);
    }

    protected SnowFlakeIdGenerator(int machineCount, int machineId) {
        int maxMachineCount = ~(-1 << 20);
        if (machineCount < 1 || machineCount > maxMachineCount) {
            throw new IllegalArgumentException("machineCount must > 0 and <= " + machineCount + " but got " + maxMachineCount);
        }
        if (machineId < 0 || machineId >= machineCount) {
            throw new IllegalArgumentException("machineId must >= 0 and < " + machineCount + " but got " + machineId);
        }

        this.machineId = machineId;
        this.sequence = 0;

        int sequenceBitCount = 21 - getBitCount(machineCount - 1);
        this.maxSequence = ~(-1 << sequenceBitCount);
        this.machineIdBitLeftOffset = sequenceBitCount;
        this.timestampBitLeftOffset = DEFAULT_TIMESTAMP_BIT_OFFSET;
    }

    protected int getBitCount(int n) {
        int c = 0;
        while (n > 0) {
            n = n >> 1;
            c += 1;
        }
        return c;
    }

    public synchronized long nextLongId() {
        long curTimestamp = System.currentTimeMillis();
        if (curTimestamp < lastTimestamp) {
            throw new RuntimeException("Clock moved backwards. Last timestamp is " + lastTimestamp + ", but current is "
                    + curTimestamp + ", refuse to generate id for " + (lastTimestamp - curTimestamp) + " ms.");
        }
        if (curTimestamp == lastTimestamp) {
            // 在同一个毫秒内，对 sequence 进行递增
            sequence = (sequence + 1) & maxSequence;
            if (sequence == 0) {
                // 超出 sequence 的最大值，则等待至下一毫秒
                curTimestamp = waitUntilNextTimestamp();
            }
        } else {
            // 不在同一个毫秒内，则 sequence 从 0 开始重新计数
            sequence = 0;
        }
        // 记录当前的毫秒时间戳
        lastTimestamp = curTimestamp;
        // 生成ID
        return (curTimestamp << timestampBitLeftOffset) | (machineId << machineIdBitLeftOffset) | sequence;
    }

    protected long waitUntilNextTimestamp() {
        long stamp = System.currentTimeMillis();
        while (stamp <= this.lastTimestamp) {
            stamp = System.currentTimeMillis();
        }
        return stamp;
    }

    @Override
    public String nextId() {
        return String.valueOf(this.nextLongId());
    }
}
