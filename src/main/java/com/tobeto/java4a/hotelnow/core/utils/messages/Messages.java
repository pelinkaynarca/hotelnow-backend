package com.tobeto.java4a.hotelnow.core.utils.messages;


public class Messages {

    public static class Error {
        public static final String CUSTOM_BAD_REQUEST = "Server Error. Please try again later!";
        public static final String CUSTOM_ROOM_TYPE_NOT_FOUND = "The requested Room Type was not found.";
        public static final String CUSTOM_STAFF_NOT_FOUND = "Staff(s) not found.";
        public static final String AUTHORIZATION_VIOLATION = "You are not authorized to do this operation.";
    }

    public static class Success {
        public static final String CUSTOM_LISTED_SUCCESSFULLY = "Successfully Listed";
        public static final String CUSTOM_CREATED_SUCCESSFULLY = "Successfully Created";
        public static final String CUSTOM_UPDATED_SUCCESSFULLY = "Successfully Updated";
        public static final String CUSTOM_DELETED_SUCCESSFULLY = "Successfully Deleted";
    }
}
