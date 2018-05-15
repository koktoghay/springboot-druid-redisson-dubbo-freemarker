package com.loveq.log;

import ch.qos.logback.classic.AsyncAppender;
import ch.qos.logback.classic.spi.ILoggingEvent;

/**
 * Created by tommy on 2017/6/26.
 */
public class SafeAsyncAppender extends AsyncAppender {

    public static final int MAX_QUEUE_SIZE = 1000;

    public SafeAsyncAppender() {
        super();
        this.setQueueSize(MAX_QUEUE_SIZE);

        //队列可用空间低于100时开始执行丢弃策略
        this.setDiscardingThreshold(100);
    }

    /**
     * 直接丢弃
     *
     * @param event
     * @return
     */
    @Override
    protected boolean isDiscardable(ILoggingEvent event) {
        return true;
    }
}
