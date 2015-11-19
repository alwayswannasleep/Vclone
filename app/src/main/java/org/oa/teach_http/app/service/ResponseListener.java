package org.oa.teach_http.app.service;

import java.util.List;

public interface ResponseListener<T> {

    void onResponse(List<T> items);
}
