CREATE TABLE `factory`.`roles`
(
    `Id_role`     BIGINT       NOT NULL AUTO_INCREMENT,
    `Title`       VARCHAR(45)  NOT NULL,
    `Symbol`      VARCHAR(45)  NOT NULL,
    `Description` VARCHAR(250) NULL,
    PRIMARY KEY (`Id_role`),
    UNIQUE INDEX `Id_role_UNIQUE` (`Id_role` ASC) VISIBLE,
    UNIQUE INDEX `Title_UNIQUE` (`Title` ASC) VISIBLE,
    UNIQUE INDEX `Symbol_UNIQUE` (`Symbol` ASC) VISIBLE
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8
    COLLATE = utf8_unicode_ci;

CREATE TABLE `factory`.`users`
(
    `Id_user`    BIGINT       NOT NULL AUTO_INCREMENT,
    `Id_role`    BIGINT       NOT NULL,
    `First_name` VARCHAR(50)  NOT NULL,
    `Last_name`  VARCHAR(50)  NOT NULL,
    `Login`      VARCHAR(50)  NOT NULL,
    `Email`      VARCHAR(100) NOT NULL,
    `Password`   VARCHAR(80)  NOT NULL,
    PRIMARY KEY (`Id_user`),
    UNIQUE INDEX `Id_user_UNIQUE` (`Id_user` ASC) VISIBLE,
    UNIQUE INDEX `Login_UNIQUE` (`Login` ASC) VISIBLE,
    UNIQUE INDEX `Email_UNIQUE` (`Email` ASC) VISIBLE,
    INDEX `Id_user_role_idx` (`Id_role` ASC) VISIBLE,
    CONSTRAINT `Id_user_role`
        FOREIGN KEY (`Id_role`)
            REFERENCES `factory`.`roles` (`Id_role`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8
    COLLATE = utf8_unicode_ci;

CREATE TABLE `factory`.`points_config`
(
    `Id_point_config` BIGINT NOT NULL AUTO_INCREMENT,
    `Default_points`  INT    NOT NULL,
    `Extra_points`    INT    NOT NULL,
    PRIMARY KEY (`Id_point_config`),
    UNIQUE INDEX `Id_point_config_UNIQUE` (`Id_point_config` ASC) VISIBLE
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8
    COLLATE = utf8_unicode_ci;

CREATE TABLE `factory`.`work_logs`
(
    `Id_work_log`   BIGINT   NOT NULL AUTO_INCREMENT,
    `Id_user`       BIGINT   NOT NULL,
    `Work_date`     DATETIME NOT NULL,
    `Amount_points` INT      NOT NULL,
    PRIMARY KEY (`Id_work_log`),
    UNIQUE INDEX `Id_work_log_UNIQUE` (`Id_work_log` ASC) VISIBLE,
    INDEX `Id_work_log_user_idx` (`Id_user` ASC) VISIBLE,
    CONSTRAINT `Id_work_log_user`
        FOREIGN KEY (`Id_user`)
            REFERENCES `factory`.`users` (`Id_user`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8
    COLLATE = utf8_unicode_ci;

CREATE TABLE `factory`.`units`
(
    `Id_unit`     BIGINT       NOT NULL AUTO_INCREMENT,
    `Title`       VARCHAR(100) NOT NULL,
    `Description` VARCHAR(250) NULL,
    `Status`      VARCHAR(50)  NOT NULL,
    PRIMARY KEY (`Id_unit`),
    UNIQUE INDEX `Id_unit_UNIQUE` (`Id_unit` ASC) VISIBLE,
    UNIQUE INDEX `Title_UNIQUE` (`Title` ASC) VISIBLE
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8
    COLLATE = utf8_unicode_ci;

CREATE TABLE `factory`.`work_places`
(
    `Id_work_place` BIGINT       NOT NULL AUTO_INCREMENT,
    `Id_unit`       BIGINT       NOT NULL,
    `Title`         VARCHAR(100) NOT NULL,
    `Size`          INT          NOT NULL,
    PRIMARY KEY (`Id_work_place`),
    UNIQUE INDEX `Id_work_place_UNIQUE` (`Id_work_place` ASC) VISIBLE,
    INDEX `Id_work_place_unit_idx` (`Id_unit` ASC) VISIBLE,
    CONSTRAINT `Id_work_place_unit`
        FOREIGN KEY (`Id_unit`)
            REFERENCES `factory`.`units` (`Id_unit`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8
    COLLATE = utf8_unicode_ci;

CREATE TABLE `factory`.`user_places`
(
    `Id_user_place` BIGINT NOT NULL AUTO_INCREMENT,
    `Id_work_place` BIGINT NOT NULL,
    `Id_user`       BIGINT NOT NULL,
    PRIMARY KEY (`Id_user_place`),
    UNIQUE INDEX `Id_user_place_UNIQUE` (`Id_user_place` ASC) VISIBLE,
    INDEX `Id_user_place_user_idx` (`Id_user` ASC) VISIBLE,
    INDEX `Id_user_place_work_place_idx` (`Id_work_place` ASC) VISIBLE,
    CONSTRAINT `Id_user_place_user`
        FOREIGN KEY (`Id_user`)
            REFERENCES `factory`.`users` (`Id_user`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `Id_user_place_work_place`
        FOREIGN KEY (`Id_work_place`)
            REFERENCES `factory`.`work_places` (`Id_work_place`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8
    COLLATE = utf8_unicode_ci;

CREATE TABLE `factory`.`personal_schedules`
(
    `Id_personal_schedule` BIGINT NOT NULL AUTO_INCREMENT,
    `Amount_days`          INT    NOT NULL,
    PRIMARY KEY (`Id_personal_schedule`),
    UNIQUE INDEX `Id_personal_schedule_UNIQUE` (`Id_personal_schedule` ASC) VISIBLE
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8
    COLLATE = utf8_unicode_ci;

CREATE TABLE `factory`.`users_personal_schedules`
(
    `Id_user_personal_schedule` BIGINT   NOT NULL AUTO_INCREMENT,
    `Id_personal_schedule`      BIGINT   NOT NULL,
    `Id_user`                   BIGINT   NOT NULL,
    `Work_date`                 DATETIME NOT NULL,
    PRIMARY KEY (`Id_user_personal_schedule`),
    UNIQUE INDEX `Id_user_personal_schedule_UNIQUE` (`Id_user_personal_schedule` ASC) VISIBLE,
    INDEX `Id_personal_schedule_idx` (`Id_personal_schedule` ASC) VISIBLE,
    INDEX `Id_user_idx` (`Id_user` ASC) VISIBLE,
    CONSTRAINT `Id_personal_schedule`
        FOREIGN KEY (`Id_personal_schedule`)
            REFERENCES `factory`.`personal_schedules` (`Id_personal_schedule`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `Id_user`
        FOREIGN KEY (`Id_user`)
            REFERENCES `factory`.`users` (`Id_user`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8
    COLLATE = utf8_unicode_ci;

ALTER TABLE `factory`.`users_personal_schedules`
    ADD COLUMN `Confirm` TINYINT(1) NOT NULL AFTER `Work_date`;