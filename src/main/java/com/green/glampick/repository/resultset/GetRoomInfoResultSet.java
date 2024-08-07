package com.green.glampick.repository.resultset;

import java.util.List;

public interface GetRoomInfoResultSet {
    String getRoomName();
    Integer getPrice();
    Integer getPeopleNum();
    Integer getPeopleMax();
    String getInTime();
    String getOutTime();
}

