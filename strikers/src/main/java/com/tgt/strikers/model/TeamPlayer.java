package com.tgt.strikers.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamPlayer {

    @NotNull
    @PrimaryKeyColumn(name = "teamid", type = PrimaryKeyType.PARTITIONED)
    private UUID teamId;

    @NotNull
    @PrimaryKeyColumn(name = "playerid",type = PrimaryKeyType.CLUSTERED, ordinal = 1)
    private UUID playerId;
    
    @Coulmn("pfirstname")
    private String playerFirstName;

    @Column("player_last_name")
    private String playerLastName;

    @Column("player_initials")
    private String playerInitials;

}
