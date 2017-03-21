package hight.sa.model;

import java.util.Date;

public class FileInfo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column file_info.id
     *
     * @mbg.generated Tue Mar 21 23:20:10 CST 2017
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column file_info.file_name
     *
     * @mbg.generated Tue Mar 21 23:20:10 CST 2017
     */
    private String fileName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column file_info.file_type
     *
     * @mbg.generated Tue Mar 21 23:20:10 CST 2017
     */
    private String fileType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column file_info.file_owner
     *
     * @mbg.generated Tue Mar 21 23:20:10 CST 2017
     */
    private String fileOwner;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column file_info.file_path
     *
     * @mbg.generated Tue Mar 21 23:20:10 CST 2017
     */
    private String filePath;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column file_info.uploaded_at
     *
     * @mbg.generated Tue Mar 21 23:20:10 CST 2017
     */
    private Date uploadedAt;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column file_info.id
     *
     * @return the value of file_info.id
     *
     * @mbg.generated Tue Mar 21 23:20:10 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column file_info.id
     *
     * @param id the value for file_info.id
     *
     * @mbg.generated Tue Mar 21 23:20:10 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column file_info.file_name
     *
     * @return the value of file_info.file_name
     *
     * @mbg.generated Tue Mar 21 23:20:10 CST 2017
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column file_info.file_name
     *
     * @param fileName the value for file_info.file_name
     *
     * @mbg.generated Tue Mar 21 23:20:10 CST 2017
     */
    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column file_info.file_type
     *
     * @return the value of file_info.file_type
     *
     * @mbg.generated Tue Mar 21 23:20:10 CST 2017
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column file_info.file_type
     *
     * @param fileType the value for file_info.file_type
     *
     * @mbg.generated Tue Mar 21 23:20:10 CST 2017
     */
    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column file_info.file_owner
     *
     * @return the value of file_info.file_owner
     *
     * @mbg.generated Tue Mar 21 23:20:10 CST 2017
     */
    public String getFileOwner() {
        return fileOwner;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column file_info.file_owner
     *
     * @param fileOwner the value for file_info.file_owner
     *
     * @mbg.generated Tue Mar 21 23:20:10 CST 2017
     */
    public void setFileOwner(String fileOwner) {
        this.fileOwner = fileOwner == null ? null : fileOwner.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column file_info.file_path
     *
     * @return the value of file_info.file_path
     *
     * @mbg.generated Tue Mar 21 23:20:10 CST 2017
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column file_info.file_path
     *
     * @param filePath the value for file_info.file_path
     *
     * @mbg.generated Tue Mar 21 23:20:10 CST 2017
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column file_info.uploaded_at
     *
     * @return the value of file_info.uploaded_at
     *
     * @mbg.generated Tue Mar 21 23:20:10 CST 2017
     */
    public Date getUploadedAt() {
        return uploadedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column file_info.uploaded_at
     *
     * @param uploadedAt the value for file_info.uploaded_at
     *
     * @mbg.generated Tue Mar 21 23:20:10 CST 2017
     */
    public void setUploadedAt(Date uploadedAt) {
        this.uploadedAt = uploadedAt;
    }
}