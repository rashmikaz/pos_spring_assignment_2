package com.example.pos_assignment_2_spring.CustomerStatusCode;

import com.example.pos_assignment_2_spring.dto.CustomerStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedErrorStatus implements CustomerStatus {
    private int statusCode;
    private String statusMessage;
}
