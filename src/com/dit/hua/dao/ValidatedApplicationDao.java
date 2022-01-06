package com.dit.hua.dao;
import com.dit.hua.entity.*;
import java.util.*;

public interface ValidatedApplicationDao{
    void insertValidatedApplication(ValidatedApplication validatedApplication);
    List<ValidatedApplication> getValidatedApplications();
}