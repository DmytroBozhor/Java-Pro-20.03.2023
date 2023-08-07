package org.example.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebFilter(filterName = "LoggingFilter", urlPatterns = "/*")
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        PrintWriter printWriter = resp.getWriter();

        Enumeration<String> headersNames = req.getHeaderNames();

        while (headersNames.hasMoreElements()) {
            String headerName = headersNames.nextElement();
            printWriter.write("\n" + headerName + ": " + req.getHeader(headerName));
        }

        printWriter.write("\n" + req.getRequestURI());
        printWriter.write("\n" + req.getContextPath());
        printWriter.write("\n" + req.getServletPath());
        printWriter.write("\n" + req.getRequestURL());
        printWriter.write("\n" + req.getAuthType());
        printWriter.write("\n" + req.getPathInfo());
        printWriter.write("\n" + req.getPathTranslated());
        printWriter.write("\n" + req.getQueryString());
        printWriter.write("\n" + req.getRemoteUser());
        printWriter.write("\n" + req.getRequestedSessionId());
        printWriter.write("\n" + req.getCharacterEncoding());
        printWriter.write("\n" + req.getContentLength());
        printWriter.write("\n" + req.getContentType());
        printWriter.write("\n" + req.getLocalName());
        printWriter.write("\n" + req.getLocalPort());
        printWriter.write("\n" + req.getProtocol());
        printWriter.write("\n" + req.getProtocolRequestId());
        printWriter.write("\n" + req.getScheme());
        printWriter.write("\n" + req.getServerName());
        printWriter.write("\n" + req.getServerPort());

        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            printWriter.write("\n" + cookie);
        }

        printWriter.close();

        chain.doFilter(request, response);
    }
}
