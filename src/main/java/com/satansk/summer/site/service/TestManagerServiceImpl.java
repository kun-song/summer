package com.satansk.summer.site.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.satansk.summer.site.util.SiteUtil.getThreadN;

/**
 * Author:  satansk
 * Email:   satansk@hotmail.com
 * Date:    17/6/29
 */
@Service
public class TestManagerServiceImpl implements TestManagerService {

    private static final Logger logger = LoggerFactory.getLogger(TestManagerServiceImpl.class);

    private ExecutorService executor = Executors.newFixedThreadPool(getThreadN());

    @Override
    public HashMap<String, String> runTests(int[] ids) {

        HashMap<String, String> result = new HashMap<>();

        return result;
    }
}
