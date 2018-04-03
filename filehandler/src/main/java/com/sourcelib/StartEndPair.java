package com.sourcelib;

/**
 * 2018/4/3
 * <p/>
 * Created by zhuqiang3
 */
public class StartEndPair {
    private long start;
    private long end;

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "StartEndPair{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StartEndPair)) return false;

        StartEndPair that = (StartEndPair) o;

        if (getStart() != that.getStart()) return false;
        return getEnd() == that.getEnd();

    }

    @Override
    public int hashCode() {
        int result = (int) (getStart() ^ (getStart() >>> 32));
        result = 31 * result + (int) (getEnd() ^ (getEnd() >>> 32));
        return result;
    }
}
