package leunam.sparelajarte.models.Mensaje;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Created by manuel on 19/05/2016.
 */
public class Mensaje {


    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("next")
    @Expose
    private Object next;
    @SerializedName("previous")
    @Expose
    private Object previous;
    @SerializedName("results")
    @Expose
    private List<Result> results = new ArrayList<Result>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Mensaje() {
    }

    /**
     *
     * @param results
     * @param previous
     * @param count
     * @param next
     */
    public Mensaje(Integer count, Object next, Object previous, List<Result> results) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }

    /**
     *
     * @return
     * The count
     */
    public Integer getCount() {
        return count;
    }

    /**
     *
     * @param count
     * The count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    public Mensaje withCount(Integer count) {
        this.count = count;
        return this;
    }

    /**
     *
     * @return
     * The next
     */
    public Object getNext() {
        return next;
    }

    /**
     *
     * @param next
     * The next
     */
    public void setNext(Object next) {
        this.next = next;
    }

    public Mensaje withNext(Object next) {
        this.next = next;
        return this;
    }

    /**
     *
     * @return
     * The previous
     */
    public Object getPrevious() {
        return previous;
    }

    /**
     *
     * @param previous
     * The previous
     */
    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    public Mensaje withPrevious(Object previous) {
        this.previous = previous;
        return this;
    }

    /**
     *
     * @return
     * The results
     */
    public List<Result> getResults() {
        return results;
    }

    /**
     *
     * @param results
     * The results
     */
    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Mensaje withResults(List<Result> results) {
        this.results = results;
        return this;
    }

}
