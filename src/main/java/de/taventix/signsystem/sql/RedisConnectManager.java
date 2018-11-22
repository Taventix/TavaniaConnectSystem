package de.taventix.signsystem.sql;

import com.lambdaworks.redis.RedisClient;
import com.lambdaworks.redis.RedisConnection;
import com.lambdaworks.redis.RedisURI;

import java.util.Timer;
import java.util.TimerTask;

public class RedisConnectManager {

    public String hostname = "";
    public String username = "";
    public String password = "";

    public RedisConnection<String, String> connection;
    public RedisClient redisClient;

    public RedisConnectManager(String hostname, String username, String password) {
        this.hostname = hostname;
        this.username = username;
        this.password = password;
        redisClient = new RedisClient(RedisURI.create("rediss://" + password + hostname + ":3306"));
        connection = redisClient.connect();
        System.out.println("[SQL] Redis connected successfully to the database.");
    }

    public void openSQLConnection() {
        if (connection == null) {
            RedisClient redisClient = new RedisClient(RedisURI.create("rediss://" + password + hostname + ":3306"));
            connection = redisClient.connect();
            System.out.println("[SQL] Redis connected successfully to the database!");
        } else {
            System.out.println("[SQL] Tried to connect, but Redis is already connected.");
        }
    }

    public void closeSQLConnection() {
        connection.close();
        redisClient.shutdown();
        System.out.println("[SQL] The connection to redis is now closed.");
    }

    public void reconnectSQLConnection() {
        if (connection == null) {
            RedisClient redisClient = new RedisClient(RedisURI.create("rediss://" + password + hostname + ":3306"));
            connection = redisClient.connect();
            System.out.println("[SQL] Redis connected successfully to the database!");
        } else {
            connection.close();
            redisClient.shutdown();
            System.out.println("[SQL] The connection to redis is now closed.");
            System.out.println("[SQL] Waiting 3 seconds to reconnect...");
            final Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    RedisClient redisClient = new RedisClient(RedisURI.create("rediss://" + password + hostname + ":3306"));
                    connection = redisClient.connect();
                    System.out.println("[SQL] Redis connected successfully to the database!");
                }
            }, 3000);
        }
    }

    public void setQuery(String key, String value) {
        connection.set(key, value);
    }

    public void getQuery(String key) {
        connection.get(key);
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHostname() {
        return hostname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
