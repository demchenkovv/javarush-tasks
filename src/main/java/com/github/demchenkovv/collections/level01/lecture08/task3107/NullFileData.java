package com.github.demchenkovv.collections.level01.lecture08.task3107;

public class NullFileData implements FileData {
    private Exception exception;

    public NullFileData(Exception e) {
        this.exception = e;
    }

    public Exception getException() {
        return exception;
    }

    @Override
    public boolean isHidden() {
        return false;
    }

    @Override
    public boolean isExecutable() {
        return false;
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public boolean isWritable() {
        return false;
    }
}
