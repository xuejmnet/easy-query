package com.easy.query.core.job;

import com.easy.query.core.basic.thread.EasyQueryThreadFactory;
import com.easy.query.core.configuration.EasyQueryOption;
import com.easy.query.core.exception.EasyQueryInvalidOperationException;
import com.easy.query.core.inject.ServiceProvider;
import com.easy.query.core.logging.Log;
import com.easy.query.core.logging.LogFactory;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * create time 2023/6/12 15:20
 * 文件说明
 *
 * @author xuejiaming
 */
public class DefaultEasyTimeJobManager implements EasyTimeJobManager {
    private static final Log log = LogFactory.getLog(DefaultEasyTimeJobManager.class);
    private final CopyOnWriteArrayList<TimeJobEntry> jobs = new CopyOnWriteArrayList<>();
    private final ScheduledExecutorService scheduledExecutorService;
    private final ServiceProvider serviceProvider;
    private final boolean logDebug;

    public DefaultEasyTimeJobManager(EasyQueryOption easyQueryOption, ServiceProvider serviceProvider) {

        this.serviceProvider = serviceProvider;
        this.logDebug = log.isDebugEnabled();
        if(easyQueryOption.isStartTimeJob()){

            this.scheduledExecutorService=Executors.newSingleThreadScheduledExecutor(new EasyQueryThreadFactory("TimeJobScheduledThread"));

            this.scheduledExecutorService.scheduleAtFixedRate(() -> {
                try {
                    long now = System.currentTimeMillis();
                    for (TimeJobEntry job : jobs) {
                        if (now > job.getNextTime()) {
                            try {
                                if (logDebug){
                                    log.debug("job:" + job.jobName()+" execute.");
                                }
                                job.execute(serviceProvider);
                            } catch (Exception ex) {
                                log.error("job:" + job.jobName() + " error.", ex);
                            } finally {
                                job.calcNextTime();
                            }
                        }
                    }
                } catch (Throwable e) {
                    log.error("schedule time job error.", e);
                }

            }, 1000 * 5, 1000 * 60, TimeUnit.MILLISECONDS);//延迟5秒 每60秒执行一次
        }else{
            this.scheduledExecutorService=null;
        }
    }

    @Override
    public void add(TimeJob job) {
        if(this.scheduledExecutorService==null){
            throw new EasyQueryInvalidOperationException("not config start time job");
        }
        jobs.add(new TimeJobEntry(job));
    }

    @Override
    public void shutdown() {
        if(this.scheduledExecutorService!=null){
            this.scheduledExecutorService.shutdown();
        }
    }
}
