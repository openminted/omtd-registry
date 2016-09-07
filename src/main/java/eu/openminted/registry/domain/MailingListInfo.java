package eu.openminted.registry.domain;

import java.util.List;

/**
 * Created by stefania on 9/5/16.
 */
public class MailingListInfo {

    private String mailingListName;
    private String subscribe;
    private String unSubscribe;
    private String post;
    private String archive;
    private List<String> otherArchives;

    public MailingListInfo() {
    }

    public MailingListInfo(String mailingListName, String subscribe, String unSubscribe, String post, String archive,
                           List<String> otherArchives) {
        this.mailingListName = mailingListName;
        this.subscribe = subscribe;
        this.unSubscribe = unSubscribe;
        this.post = post;
        this.archive = archive;
        this.otherArchives = otherArchives;
    }

    public String getMailingListName() {
        return mailingListName;
    }

    public void setMailingListName(String mailingListName) {
        this.mailingListName = mailingListName;
    }

    public String getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(String subscribe) {
        this.subscribe = subscribe;
    }

    public String getUnSubscribe() {
        return unSubscribe;
    }

    public void setUnSubscribe(String unSubscribe) {
        this.unSubscribe = unSubscribe;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getArchive() {
        return archive;
    }

    public void setArchive(String archive) {
        this.archive = archive;
    }

    public List<String> getOtherArchives() {
        return otherArchives;
    }

    public void setOtherArchives(List<String> otherArchives) {
        this.otherArchives = otherArchives;
    }
}
