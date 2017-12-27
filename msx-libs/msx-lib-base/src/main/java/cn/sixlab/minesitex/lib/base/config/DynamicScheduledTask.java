///**
// * Copyright (c) 2017 Sixlab. All rights reserved.
// * <p>
// * License information see the LICENSE file in the project's root directory.
// * <p>
// * For more information, please see
// * https://sixlab.cn/
// *
// * @time: 2017/12/12 17:50
// * @author: Patrick <root@sixlab.cn>
// */
//package cn.sixlab.minesitex.lib.base.config;
//
//import org.springframework.scheduling.Trigger;
//import org.springframework.scheduling.TriggerContext;
//import org.springframework.scheduling.annotation.SchedulingConfigurer;
//import org.springframework.scheduling.config.ScheduledTaskRegistrar;
//import org.springframework.scheduling.support.CronTrigger;
//
//import java.util.Date;
//
//public class DynamicScheduledTask implements SchedulingConfigurer {
//    public static String cron = "0/5 * * * * *";
//
//    @Override
//    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
//        Runnable task = new Runnable() {
//            @Override
//            public void run() {
//                //任务逻辑代码部分.
//                System.out.println("TaskCronChange task is running ... " + new Date());
//            }
//        };
//
//        Trigger trigger = new Trigger() {
//            @Override
//            public Date nextExecutionTime(TriggerContext triggerContext) {
//                //任务触发，可修改任务的执行周期.
//                CronTrigger trigger = new CronTrigger(cron);
//                Date nextExec = trigger.nextExecutionTime(triggerContext);
//                return nextExec;
//            }
//        };
//        taskRegistrar.addTriggerTask(task, trigger);
//    }
//
//}