package com.sourcelib;

import java.io.RandomAccessFile;
import java.util.Set;
import java.util.concurrent.ExecutorService;

/**
 * 2018/4/3
 * <p/>
 * Created by zhuqiang3
 */
public class FileHanderClient {
    //待处理文件
    private RandomAccessFile rAccessFile;
    //线程池
    private ExecutorService executorService;
    //线程数
    private int threadsize;
    //切分文件
    private FileSegment fileSegment;
    //处理读取的每段文件
    private FileHandler fileHandler;
    //文件分片集合
    private Set<StartEndPair> startEndPairs;

}
