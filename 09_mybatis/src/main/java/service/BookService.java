package service;

import javax.servlet.http.HttpServletRequest;

import common.ActionForward;

public interface BookService {
    public ActionForward addBook(HttpServletRequest request);
    public ActionForward getBookList(HttpServletRequest request);
    public ActionForward getBookDetail(HttpServletRequest request);
    public ActionForward editBook(HttpServletRequest request);
    public ActionForward modifyBook(HttpServletRequest request);
    public ActionForward deleteBook(HttpServletRequest request);
}
