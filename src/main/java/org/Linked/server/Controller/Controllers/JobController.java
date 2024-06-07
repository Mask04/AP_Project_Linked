package org.Linked.server.Controller.Controllers;

import org.Linked.server.Model.Job;

import java.sql.SQLException;
import java.util.ArrayList;

public class JobController extends Controller{
    public static String getJob (String email) throws SQLException {
        Job job = JobDAO.getJobByEmail(email);
        return job == null ? null : gson.toJson(job);
    }

    public static String getAllJobs () throws SQLException {
        ArrayList<Job> jobs = JobDAO.getAllJobs();
        return gson.toJson(jobs);
    }

    public static void createJob (String json) throws SQLException {
        Job job = gson.fromJson(json, Job.class);

        if (UserDAO.getUserByEmail(job.getEmail()) == null) throw new SQLException("User does not exist");

        if (JobDAO.getJobByEmail(job.getEmail()) == null){
            JobDAO.saveJob(job);
        } else {
            JobDAO.updateJob(job);
        }
    }

    public static void deleteJob (String email) throws SQLException {
        JobDAO.deleteJobByEmail(email);
    }

    public static void deleteAllJobs () throws SQLException {
        JobDAO.deleteAllJobs();
    }
}