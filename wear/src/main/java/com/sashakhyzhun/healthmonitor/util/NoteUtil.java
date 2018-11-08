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
package com.sashakhyzhun.healthmonitor.util;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.wearable.activity.ConfirmationActivity;

import com.sashakhyzhun.healthmonitor.data.model.Note;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

// Class Helper for working with Notes.
public class NoteUtil {

    public NoteUtil() {
        // context
    }

    /**
     * Method to save note.
     * We convert voice message to text and store it Shared Preferences;
     * Then we put the current UNIX time in our SharedPreferences as a unique identifier,
     * and we receive and put the text of the voice message in the "Title"
     * @param note - model for working with notes, has parameters 'title' and 'id';
     * @param context - current activity context, because this is helper class, vse ok;
     * @ return: identify of current note, actually this is unix time
     */
    public static void saveNote(Note note, Context context) throws Exception {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String id = String.valueOf(System.currentTimeMillis());
        editor.putString(id, note.getTitle());

        editor.apply();
        editor.commit();
    }


    /**
     * Method to get all Notes and put it in list view.
     * We created ArrayList with Notes, then get all notes from our SharedPreference if SP is not null
     * then we put it in our ArrayList<Note> and return her.
     * @param context - current context of activity, because this is helper class, vse ok;
     * @return ArrayList with Notes for list view
     */
    public static ArrayList<Note> getAllNotes(Context context) throws Exception {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        ArrayList<Note> notes = new ArrayList<>();

        TreeMap<String, ?> key = new TreeMap<>(sharedPreferences.getAll());

        System.out.println("key: " + key);

        for (Map.Entry<String, ?> entry : key.entrySet()) {
            String entryValue = (String) entry.getValue();
            System.out.println("entryValue: " + entryValue);

            if (entryValue != null) {
                Note note = new Note(entryValue, entry.getKey());
                notes.add(note);
                System.out.println("note: " + note);
                System.out.println("note: " + note.getId() + " : " + note.getTitle());
            }
        }


        return notes;
    }


    /**
     * Method for delete current Note from list view;
     * We click on some element in list view after then had see 'DeleteMenu' (activity).
     * In this time we get current ID by Title of element and just remove it from SharedPreference.
     * @param id - unique identify in our SharedPreference (UnixTime)
     * @param context - current context of activity, because this is helper class, vse ok;
     */
    public static void removeNote(String id, Context context) throws Exception {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.remove(id);
        editor.apply();
    }


    /**
     * Method which communicate with user.
     * We show activity with some information about the current Notice.
     * If we have created something new, we should have seen a message "successfully created",
     * or if we have something to remove, we should have seen the "deleted successfully" message.
     * @param message - the text which depends on the action
     * @param context - current context of activity, because this is helper class, vse ok;
     */
    public static void displayConfirmation(String message, Context context) throws Exception {
        Intent intent = new Intent(context, ConfirmationActivity.class);
        intent.putExtra(ConfirmationActivity.EXTRA_ANIMATION_TYPE, ConfirmationActivity.SUCCESS_ANIMATION);

        intent.putExtra(ConfirmationActivity.EXTRA_MESSAGE, message);
        context.startActivity(intent);
    }

}
