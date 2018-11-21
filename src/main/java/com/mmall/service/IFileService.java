package com.mmall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author LiYingChun
 * @date 2018/11/20
 */
public interface IFileService {

    String upload(MultipartFile file, String path);
}
