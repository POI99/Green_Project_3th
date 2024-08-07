package com.green.glampick.dto.response.owner.get;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.green.glampick.dto.ResponseDto;
import com.green.glampick.repository.resultset.GetRoomInfoResultSet;
import com.green.glampick.repository.resultset.OwnerInfoResultSet;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static com.green.glampick.common.GlobalConst.SUCCESS_CODE;

@Getter
public class GetRoomInfoResponseDto extends ResponseDto {

    @Schema(example = "카라반 102호", description = "객실 이름")
    private String roomName;

    @Schema(example = "65500", description = "객실 가격")
    private Integer price;

    @Schema(example = "2", description = "기준 인원")
    private Integer peopleNum;

    @Schema(example = "6", description = "최대 인원")
    private Integer peopleMax;

    @Schema(example = "15:00:00", description = "입실 시간")
    private String inTime;

    @Schema(example = "12:00:00", description = "퇴실 시간")
    private String outTime;

    @Schema(example = "[room.jpg, room2.jpg]")
    private List<String> roomImgName;

    @Schema(example = "[1,2,3]", description = "객실 서비스")
    private List<Long> service;

    public GetRoomInfoResponseDto(String roomName, Integer price, Integer peopleNum,
                                  Integer peopleMax, String inTime, String outTime, List<String> roomImgName,
                                  List<Long> service){
        super(SUCCESS_CODE, "객실 상세 정보를 불러왔습니다.");
        this.roomName=roomName;
        this.price=price;
        this.peopleNum=peopleNum;
        this.peopleMax=peopleMax;
        this.inTime=inTime;
        this.outTime=outTime;
        this.roomImgName=roomImgName;
        this.service=service;
    }

    public static ResponseEntity<GetRoomInfoResponseDto> success(GetRoomInfoResultSet resultSet, List<String> roomImgName, List<Long> service) {
        GetRoomInfoResponseDto result = new GetRoomInfoResponseDto(resultSet.getRoomName(), resultSet.getPrice()
                , resultSet.getPeopleNum(), resultSet.getPeopleMax(), resultSet.getInTime(), resultSet.getOutTime(), roomImgName, service);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
