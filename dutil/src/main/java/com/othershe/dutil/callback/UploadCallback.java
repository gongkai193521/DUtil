package com.othershe.dutil.callback;

public interface UploadCallback extends FileCallback {
    /**
     * 开始
     */
    void onStart();

    /**
     * 上传中
     *
     * @param currentSize
     * @param totalSize
     * @param progress
     */
    void onProgress(long currentSize, long totalSize, float progress);

    /**
     * 完成
     */
    void onFinish();


    /**
     * 出错
     *
     * @param error
     */
    void onError(String error);
}
