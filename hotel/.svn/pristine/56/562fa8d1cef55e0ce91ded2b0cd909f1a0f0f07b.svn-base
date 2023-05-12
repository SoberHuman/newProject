房间类型表
create table roomType 
(
   roomTypeId          int primary key auto_increment,
   roomTypeName        varchar(200),
   roomTypeImage       varchar(255),
   roomTypeStatus      int,
   roomTypeArea        double,
   roomTypeTimingMode  int,
   listPrice            double,
   individualPrice      double,
   vipPrice             double
);
房间信息表
create table room 
(
   roomId               int primary key auto_increment,
   roomTypeId           int,
   roomNumber            varchar(50),
   roomSanitation       int,
   roomStatus           int,
   roomStorey           varchar(100),
   roomWindow           varchar(200),
   roomBed              varchar(200),
   roomGuestNumber      int,
   roomFacility         text,
   checkinId            int
);
房价表
create table roomrate 
(
   roomrateId           int primary key auto_increment,
   roomTypeId           int,
   listPrice            double,
   individualPrice      double,
   vipPrice             double
);
维修记录表
create table maintain 
(
   maintainId           int primary key auto_increment,
   roomId               int,
   staffId              int,
   maintainCause        varchar(200),
   maintainStartTime    datetime,
   maintainFinishTime   datetime,
   maintainStatus       int,
   maintainResult       varchar(200)
);
入住登记表
create table checkin 
(
   checkinId           int primary key auto_increment,
   roomId               int,
   roomTypeId           int,
   staffId              int,
   usersId              int,
   clientId              int,
   checkinTime          datetime,
   DepartureTime        datetime,
   checkinDay             int,
   checkinForegift      double
);
员工表
create table staff 
(
   staffId             int primary key auto_increment,
   staffAccount         varchar(200),
   staffPassword        varchar(200),
   staffName            varchar(200)
);
会员客户信息表
create table users 
(
   usersId              int primary key auto_increment,
   userVipId            varchar(200),
   userPass 			varchar(200),
   userRealName         varchar(200),
   userIdCard           varchar(200),
   userPhone            varchar(200),
   userIntegral           int
);
预订登记表
create table reservation 
(
   reservationId        int primary key auto_increment,
   roomId               int,
   roomTypeId           int,
   staffId              int,
   reservationName      varchar(200),
   reservationIdCard      varchar(200),
   reservationPhoneNumber  varchar(200),
   reservationTime      datetime,
   unsubscribeTime      datetime,
   ExpectedTimeOfArrival datetime,
   reservationOccupancyDays int,
   reservationStatus   int,
   reservationForegift  double,
   unsubscribeForegift  double
);
公告表
create table announcement 
(
   announcementId      int primary key auto_increment,
   staffId              int,
   announcementTitle    varchar(200),
   announcementContent  varchar(200),
   announcementType  	int,
   announcementState  	int,
   activityTime  		varchar(200),  
   announcementTime     date
);
普通客户表
create table client 
(
   clientId             int primary key auto_increment,
   clientName           varchar(150),
   clientIdCard         varchar(200),
   clientPhone          varchar(200)
);
会员客户消费记录表
create table userConsumptionRecord 
(
   userConsumptionRecordId int primary key auto_increment,
   usersId              int,
   staffId             int,
   userConsumptionTime  datetime,
   userConsumptionMoney double,
   userConsumptionManner int
);
普通客户消费记录表
create table clientConsumptionRecord 
(
   clientConsumptionRecordId int primary key auto_increment,
   clientId             int,
   staffId             int,
   clientConsumptionTime  datetime,
   clientConsumptionMoney double,
   clientConsumptionManner int 
);
退房登记表
create table checkOut 
(
   checkOutId           int primary key auto_increment,
   usersId              int,
   clientId             int,
   staffId              int,
   roomId               int,
   checkOutTime         datetime,
   amountReceived       double
);
收入表
create table income 
(
   incomeId             int primary key auto_increment,
   roomTypeId           int,
   staffId              int,
   paymentMethod        int,
   incomeType        	int,
   incomeTime        	datetime,
   incomeMoney          double
);

select current_date-subdate(curdate(),date_format(curdate(),'%m'));

select * from checkIn where month(checkInTime)-1=0;
SELECT * FROM checkIn WHERE WEEK(checkinTime) = WEEK(CURDATE());
select * from checkIn where week(checkinTime) = week(curdate());

insert into staff(staffAccount,staffPassword,staffName) value('admin','admin','admin');
insert into checkIn(roomId,roomTypeId,staffId,usersId,clientId,checkinTime,DepartureTime,checkinDay,checkinForegift) value(3,1,1,5,0,'2019-12-26 09:07:00','2019-12-30 00:00:00',4,150);