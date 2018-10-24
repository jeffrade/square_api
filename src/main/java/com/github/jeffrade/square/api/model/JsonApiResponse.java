package com.github.jeffrade.square.api.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Loosely following https://jsonapi.org/format/
 */
public class JsonApiResponse {

    private static final List<String> EMPTY_LIST = Collections.emptyList();

    private static final String EMPTY_STRING = "";

    private int status;

    private List<String> data;

    private List<String> errors;

    private String meta;

    private List<String> links;

    private List<String> included;

    private String self;

    private String related;

    public JsonApiResponse() {
        super();
    }

    public JsonApiResponse(int status) {
        this(status, EMPTY_LIST, EMPTY_LIST, EMPTY_STRING, null, null, null, null);
    }

    public JsonApiResponse(int status, List<String> data, List<String> errors, String meta,
            List<String> links, List<String> included, String self, String related) {
        super();
        this.status = status;
        this.data = data;
        this.errors = errors;
        this.meta = meta;
        this.links = links;
        this.included = included;
        this.self = self;
        this.related = related;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public List<String> getLinks() {
        return links;
    }

    public void setLinks(List<String> links) {
        this.links = links;
    }

    public List<String> getIncluded() {
        return included;
    }

    public void setIncluded(List<String> included) {
        this.included = included;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getRelated() {
        return related;
    }

    public void setRelated(String related) {
        this.related = related;
    }

    @Override
    public String toString() {
        return "JsonApiResponse{" +
            "status='" + status + '\'' +
            ", data=" + data +
            ", errors=" + errors +
            ", meta='" + meta + '\'' +
            ", links=" + links +
            ", included=" + included +
            ", self='" + self + '\'' +
            ", related='" + related + '\'' +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JsonApiResponse)) return false;
        JsonApiResponse that = (JsonApiResponse) o;
        return Objects.equals(status, that.status) &&
            Objects.equals(data, that.data) &&
            Objects.equals(errors, that.errors) &&
            Objects.equals(meta, that.meta) &&
            Objects.equals(links, that.links) &&
            Objects.equals(included, that.included) &&
            Objects.equals(self, that.self) &&
            Objects.equals(related, that.related);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, data, errors, meta, links, included, self, related);
    }
}
