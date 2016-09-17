package leunam.sparelajarte.models.centro;

/**
 * Created by manuel on 14/05/2016.
 */
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class Centro {

    @SerializedName("count")
    @Expose
    private Long count;
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
    public Centro() {
    }

    /**
     *
     * @param results
     * @param previous
     * @param count
     * @param next
     */
    public Centro(Long count, Object next, Object previous, List<Result> results) {
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
    public Long getCount() {
        return count;
    }

    /**
     *
     * @param count
     * The count
     */
    public void setCount(Long count) {
        this.count = count;
    }

    public Centro withCount(Long count) {
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

    public Centro withNext(Object next) {
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

    public Centro withPrevious(Object previous) {
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

    public Centro withResults(List<Result> results) {
        this.results = results;
        return this;
    }

    @Override
    public String toString() {
        return "Centro{" +
                "count=" + count +
                ", next=" + next +
                ", previous=" + previous +
                ", results=" + results +
                '}';
    }
}
