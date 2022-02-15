package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class pff implements IPQuery, UserQuery , DateQuery, EventQuery , QLQuery {
    private Path logDir;

    public List<User> sortedUsersByDate(Date after, Date before){
        List<User> users = userListFromLog();
        List<User> result = new ArrayList<>();
        if (after == null) {
            after = new Date(0);
        }
        if (before == null) {
            before = new Date(Long.MAX_VALUE);
        }
        for (User u : users){
            Date userDate = u.date;
            if (userDate.before(before) && userDate.after(after)){
                result.add(u);
            }
        }
        return result;
    }

    public List<User> userListFromLog(){
        File file = logDir.toFile();
        List<User> users = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss",Locale.ENGLISH);
        for (File f : file.listFiles()){
            if (f.isFile() && f.getName().endsWith(".log")){
                try( BufferedReader reader = new BufferedReader(new InputStreamReader(Files.newInputStream(f.toPath())))  )
                {
                    String s;

                    while ( (s = reader.readLine()) != null){
                        String[] lines = s.split("\t");
                        User user = new User();

                        user.ip = lines[0];
                        user.name = lines[1];
                        try {
                            user.date = formatter.parse(lines[2]);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        user.strDate = lines[2];

                        if (lines[3].contains(" ")){
                            user.event = Event.valueOf(lines[3].substring(0,lines[3].indexOf(" ")));
                            user.addEvent = Integer.parseInt(lines[3].substring(lines[3].indexOf(" ") + 1));
                        } else user.event = Event.valueOf(lines[3]);
                        user.status = Status.valueOf(lines[4]);
                        users.add(user);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return users;
    }

    public pff(Path logDir) {
        this.logDir = logDir;
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getUniqueIPs(after,before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        List<User> users = sortedUsersByDate(after,before);
        Set<String> result = new HashSet<>();
        for (User u : users){
            result.add(u.ip);
        }
        return result;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        List<User> users = sortedUsersByDate(after,before);
        Set<String> result = new HashSet<>();
        for (User u : users){
            if (u.name.equals(user)){
                result.add(u.ip);
            }
        }
        return result;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        List<User> users = sortedUsersByDate(after,before);
        Set<String> result = new TreeSet<>();
        for (User u : users){
            if (u.event.equals(event)){
                result.add(u.ip);
            }
        }
        return result;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        List<User> users = sortedUsersByDate(after,before);
        Set<String> result = new TreeSet<>();
        for (User u : users){
            if (u.status.equals(status)){
                result.add(u.ip);
            }
        }
        return result;
    }

    @Override
    public Set<String> getAllUsers() {
        HashSet<String> set = new HashSet<>();
        for (User user : userListFromLog()){
            set.add(user.name);
        }
        return set;
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        HashSet<String> set = new HashSet<>();
        for (User u : sortedUsersByDate(after,before)){
            set.add(u.name);
        }
        return set.size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        HashSet<Event> set = new HashSet<>();
        for (User u : sortedUsersByDate(after,before)){
            if (u.name.equals(user))
            {
                set.add(u.event);
            }
        }
        return set.size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        Set<String> set = new HashSet<>();
        for (User user : sortedUsersByDate(after,before)){
            if (user.ip.equals(ip)){
                set.add(user.name);
            }
        }
        return set;
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        Set<String> set = new HashSet<>();
        for (User user : sortedUsersByDate(after,before)){
            if (user.event.equals(Event.LOGIN)){
                set.add(user.name);
            }
        }
        return set;
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        Set<String> set = new HashSet<>();
        for (User user : sortedUsersByDate(after,before)){
            if (user.event.equals(Event.DOWNLOAD_PLUGIN)){
                set.add(user.name);
            }
        }
        return set;
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        Set<String> set = new HashSet<>();
        for (User user : sortedUsersByDate(after,before)){
            if (user.event.equals(Event.WRITE_MESSAGE)){
                set.add(user.name);
            }
        }
        return set;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        Set<String> set = new HashSet<>();
        for (User user : sortedUsersByDate(after,before)){
            if (user.event.equals(Event.SOLVE_TASK)){
                set.add(user.name);
            }
        }
        return set;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        Set<String> set = new HashSet<>();
        for (User user : sortedUsersByDate(after,before)){
            if (user.addEvent == task && user.event.equals(Event.SOLVE_TASK)){
                set.add(user.name);
            }
        }
        return set;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        Set<String> set = new HashSet<>();
        for (User user : sortedUsersByDate(after,before)){
            if (user.event.equals(Event.SOLVE_TASK) | user.event.equals(Event.DONE_TASK)){
                set.add(user.name);
            }
        }
        return set;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        Set<String> set = new HashSet<>();
        for (User user : sortedUsersByDate(after,before)){
            if (user.addEvent == task && user.event.equals(Event.DONE_TASK)){
                set.add(user.name);
            }
        }
        return set;
    }

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        HashSet<Date> set = new HashSet<>();
        for (User u : sortedUsersByDate(after,before)){
            if (u.name.equals(user) && u.event.equals(event)){
                set.add(u.date);
            }
        } return set;
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        HashSet<Date> set = new HashSet<>();
        for (User u : sortedUsersByDate(after,before)){
            if (u.status.equals(Status.FAILED)){
                set.add(u.date);
            }
        } return set;
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        HashSet<Date> set = new HashSet<>();
        for (User u : sortedUsersByDate(after,before)){
            if (u.status.equals(Status.ERROR)){
                set.add(u.date);
            }
        } return set;
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        HashSet<Date> set = new HashSet<>();
        for (User u : sortedUsersByDate(after,before)){
            if (u.name.equals(user) && u.event.equals(Event.LOGIN)){
                set.add(u.date);
            }
        }
        if (set.isEmpty()){ return null; }
        Date passed = set.iterator().next();
        for (Date date : set){
            if (date.before(passed)){
                passed = date;
            }
        }
        return passed;
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        HashSet<Date> set = new HashSet<>();
        for (User u : sortedUsersByDate(after,before)){
            if (u.name.equals(user) && u.event.equals(Event.SOLVE_TASK) && u.addEvent == task){
                set.add(u.date);
            }
        }
        if (set.size() == 0){ return null; }
        Date passed = set.iterator().next();
        for (Date date : set){
            if (date.before(passed)){
                passed = date;
            }
        }
        return passed;
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        HashSet<Date> set = new HashSet<>();
        for (User u : sortedUsersByDate(after,before)){
            if (u.name.equals(user) && u.event.equals(Event.DONE_TASK) && u.addEvent == task){
                set.add(u.date);
            }
        }
        if (set.size() == 0) {
            return null;
        }
        Date minDate = set.iterator().next();
        for (Date date : set) {
            if (date.getTime() < minDate.getTime())
                minDate = date;
        }
        return minDate;
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        HashSet<Date> set = new HashSet<>();
        for (User u : sortedUsersByDate(after,before)){
            if (u.name.equals(user) && u.event.equals(Event.WRITE_MESSAGE)){
                set.add(u.date);
            }
        }
        return set;
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        HashSet<Date> set = new HashSet<>();
        for (User u : sortedUsersByDate(after,before)){
            if (u.name.equals(user) && u.event.equals(Event.DOWNLOAD_PLUGIN)){
                set.add(u.date);
            }
        }
        return set;
    }

    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        return getAllEvents(after,before).size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        Set<Event> set = new HashSet<>();
        for (User user : sortedUsersByDate(after,before)){
            if (user.event != null){
                set.add(user.event);
            }
        }
        return set;
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        Set<Event> set = new HashSet<>();
        for (User user : sortedUsersByDate(after,before)){
            if (user.ip.equals(ip)){
                set.add(user.event);
            }
        }
        return set;
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        Set<Event> set = new HashSet<>();
        for (User u : sortedUsersByDate(after,before)){
            if (u.name.equals(user)){
                set.add(u.event);
            }
        }
        return set;
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        Set<Event> set = new HashSet<>();
        for (User u : sortedUsersByDate(after,before)){
            if (u.status.equals(Status.FAILED)){
                set.add(u.event);
            }
        }
        return set;
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        Set<Event> set = new HashSet<>();
        for (User u : sortedUsersByDate(after,before)){
            if (u.status.equals(Status.ERROR)){
                set.add(u.event);
            }
        }
        return set;
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        int count = 0;
        for (User u : sortedUsersByDate(after,before)){
            if ( ( u.addEvent == task && u.event.equals(Event.SOLVE_TASK)) ) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        int count = 0;
        for (User u : sortedUsersByDate(after,before)){
            if ( u.addEvent == task && u.event.equals(Event.DONE_TASK)){
                count++;
            }
        }
        return count;
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        Map<Integer,Integer> map = new HashMap<>();
        for (User user : sortedUsersByDate(after,before)){
            if (user.event.equals(Event.SOLVE_TASK)){
                map.put(user.addEvent,getNumberOfAttemptToSolveTask(user.addEvent,after,before));
            }
        } return map;
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        Map<Integer,Integer> map = new HashMap<>();
        for (User user : sortedUsersByDate(after,before)){
            if (user.event.equals(Event.DONE_TASK)){
                int task = user.addEvent;
                Integer count = map.containsKey(task) ? map.get(task) : 0;
                map.put(task, count + 1);
            }
        } return map;
    }

    @Override
    public Set<Object> execute(String query) {
        Set<Object> set = new HashSet<>();
        String[] splittedQuery = query.split(" ");
        if (splittedQuery.length < 3){
            switch (query){
                case ("get ip") : userListFromLog().forEach(user -> set.add(user.ip)); break;
                case ("get user") : userListFromLog().forEach(user -> set.add(user.name)); break;
                case ("get date") : userListFromLog().forEach(user -> set.add(user.date)); break;
                case ("get event") : set.addAll(getAllEvents(null,null)); break;
                case ("get status") : userListFromLog().forEach(user -> set.add(user.status)); break;
            } return set; }
        String field1 = splittedQuery[1];
        String field2 = splittedQuery[3];
        String value = splittedQuery[5].replaceAll("\\\"","");

        switch (field1){
            case ("ip") :
            case ("user") :  break;
            case ("date") :  break;
            case ("event") :  break;
            case ("status") :  break;
        }
        return set;
    }

}