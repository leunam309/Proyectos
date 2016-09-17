package leunam.sparelajarte.models.usurl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manuel on 20/02/2016.
 */
public class Result {


    private String url;

    private String username;

    private String email;

    private String first_name;

    private String last_name;

    private List<Object> groups = new ArrayList<Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Result() {
    }

    /**
     *
     * @param username
     * @param email
     * @param groups
     * @param url
     */
    public Result(String url, String username, String email, List<Object> groups) {
        this.url = url;
        this.username = username;
        this.email = email;
        this.groups = groups;
    }

    public Result(String url, String username, String email,String first_name, String last_name) {
        this.url = url;
        this.username = username;
        this.email = email;
        this.first_name= first_name;
        this.last_name = last_name;
    }

    public Result(String url, String username, String email,String first_name, String last_name, List<Object> groups) {
        this.url = url;
        this.username = username;
        this.email = email;
        this.first_name= first_name;
        this.last_name = last_name;
        this.groups = groups;
    }

    /**
     *
     * @return
     * The url
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     * The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    public Result withUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     *
     * @return
     * The username
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     * The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    public Result withUsername(String username) {
        this.username = username;
        return this;
    }

    /**
     *
     * @return
     * The email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     * The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public Result withEmail(String email) {
        this.email = email;
        return this;
    }


    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    /**
     *
     * @return
     * The groups
     */
    public List<Object> getGroups() {
        return groups;
    }

    /**
     *
     * @param groups
     * The groups
     */
    public void setGroups(List<Object> groups) {
        this.groups = groups;
    }

    public Result withGroups(List<Object> groups) {
        this.groups = groups;
        return this;
    }

}