package com.dit.hua.dao;
import com.dit.hua.entity.*;
import java.util.*;

public interface FinalApplicationDAO{
    void insertFinalApplication(FinalApplication finalApplication);
    List<FinalApplication> getFinalApplications();
}