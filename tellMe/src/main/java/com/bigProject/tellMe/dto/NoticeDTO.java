package com.bigProject.tellMe.dto;

import com.bigProject.tellMe.entity.Notice;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class NoticeDTO {
    private Integer id;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private String file;
    private Integer views;

    public static NoticeDTO toNoticeDTO(Notice notice) {
        NoticeDTO noticeDTO = new NoticeDTO();
        noticeDTO.setId(notice.getId());
        noticeDTO.setTitle(notice.getTitle());
        noticeDTO.setContent(notice.getContent());
        noticeDTO.setCreateDate(notice.getCreateDate());
        noticeDTO.setViews(notice.getViews());
        noticeDTO.setFile(notice.getFile());
        return noticeDTO;
    }
}
