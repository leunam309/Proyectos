package leunam.sparelajarte.models.usurl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manuel on 20/02/2016.
 */
public class Usurl {

    private long count;

    private Object next;

    private Object previous;

    private List<Result> results = new ArrayList<Result>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Usurl() {
    }

    /**
     *
     * @param results
     * @param previous
     * @param count
     * @param next
     */
    public Usurl(long count, Object next, Object previous, List<Result> results) {
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
    public long getCount() {
        return count;
    }

    /**
     *
     * @param count
     * The count
     */
    public void setCount(long count) {
        this.count = count;
    }

    public Usurl withCount(long count) {
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

    public Usurl withNext(Object next) {
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

    public Usurl withPrevious(Object previous) {
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

    public Usurl withResults(List<Result> results) {
        this.results = results;
        return this;
    }

}