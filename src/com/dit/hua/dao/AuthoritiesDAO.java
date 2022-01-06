package com.dit.hua.dao;
import com.dit.hua.entity.*;
import java.util.*;

public interface AuthoritiesDAO{
    void insertAuthorities(Authorities authority);
    List<Authorities> getAuthorities();


}