package org.Linked.server.Handlers;

import com.sun.net.httpserver.HttpExchange;
import org.Linked.server.Controller.Controllers.PostController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicInteger;

public class HashtagHandler extends Handler{
    @Override
    protected String handleRequest(String method, String path, HttpExchange exchange, AtomicInteger statusCode) throws SQLException, IOException {
        String[] splitPath = path.split("/");

        if (method.equals("GET")) {
            if (splitPath.length >= 3) {
                String hashtag = splitPath[splitPath.length - 1];
                String postsJson = PostController.getPostsByHashtag("#" + hashtag);
                response = postsJson == null ? "No posts found with this hashtag!" : postsJson;
                return response;
            }
        }
        response = "Unsupported method or path";

        return response;
    }
}
