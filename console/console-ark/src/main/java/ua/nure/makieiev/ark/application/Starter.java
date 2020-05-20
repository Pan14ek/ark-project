package ua.nure.makieiev.ark.application;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import ua.nure.makieiev.ark.job.FactoryJob;
import ua.nure.makieiev.ark.model.dto.LoginUser;
import ua.nure.makieiev.ark.model.entity.UserInfo;
import ua.nure.makieiev.ark.service.UserService;
import ua.nure.makieiev.ark.service.impl.UserServiceImpl;
import ua.nure.makieiev.ark.util.serialization.ObjectWriter;

import java.util.Scanner;

public class Starter {

    public static void main(String[] args) throws SchedulerException {
        UserService userService = new UserServiceImpl();
        Scanner scanner = new Scanner(System.in);
        String login;
        System.out.println("Please, write your login");
        login = scanner.nextLine();
        String password;
        System.out.println("Please, write your password");
        password = scanner.nextLine();
        LoginUser loginUser = new LoginUser(login, password);
        UserInfo userInfo = userService.signIn(loginUser);
        ObjectWriter.writeUserInfo(userInfo);
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        JobDetail jobDetail = JobBuilder.newJob(FactoryJob.class).withIdentity("Factory", "group1").build();
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("FactoryTrigger", "group1")
                .startNow().withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(30).repeatForever()).build();
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
    }

}
