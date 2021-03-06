package com.tgt.strikers.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.NotNull;

@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleById {

    @PrimaryKey
    private String userId;

    @NotNull
    @Column("user_role")
    private String userRole;
}
