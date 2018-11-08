/*
* Copyright (C) 2017 Black Orchid Studio. All Rights Reserved.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.sashakhyzhun.healthmonitor.data.model;

public class Note {

    private String title = ""; // avoid null
    private String id = ""; // avoid null

    /**
     * Constructor for create new Note
     * @param title - name of current note. child item in listView. We use voice message for it;
     * @param id - unique identifier for the child item in the ListView. Actually
     *             we use the Unix time for identity, because he never repeats
     */
    public Note(String title, String id) {
        this.title = title;
        this.id = id;
    }


    /**
     * @return title of list view
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title - text of listView's item [child]
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return unique ID of current item in listView
     */
    public String getId() {
        return id;
    }

    /**
     * @param id - unique ID of child item in listView
     */
    public void setId(String id) {
        this.id = id;
    }


}
