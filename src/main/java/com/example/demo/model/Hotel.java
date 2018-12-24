package com.example.demo.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

/**
 * 酒店表
 *
 * @author admin
 * @date 2017年10月28日下午2:07:43
 * @since 1.0
 */
@Data
@TableName("PF_HOTEL")
public class Hotel implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -2187607762439936556L;

    @TableId
    private String id = UUID.randomUUID().toString().replace("-", "");

    private String hotelId;
    private String hotelName;

    private String addr;

    private String namepy;

    private String headimage;

    private String nation;

    private String prov;

    private String city;

    private String area;

    private String switchboard;

    private String style;

    private String salespoint;

    private String opentime;

    private String star;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private String checkinfo;

    private String child;

    private String diet;

    private String pet;

    private String wifi;

    private String washsupply;

    private String aircondition;

    private String hotwater;

    private String blower;

    private String restaurant;

    private String park;

    private Integer grade;

    /**
     * 创建记录的时间
     */
    private Date createDate;

    /**
     * 删除标识(0:未删除；1：已删除)
     */
    private Integer markForDelete;

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName == null ? null : hotelName.trim();
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public void setNamepy(String namepy) {
        this.namepy = namepy == null ? null : namepy.trim();
    }

    public void setHeadimage(String headimage) {
        this.headimage = headimage == null ? null : headimage.trim();
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    public void setProv(String prov) {
        this.prov = prov == null ? null : prov.trim();
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public void setSwitchboard(String switchboard) {
        this.switchboard = switchboard == null ? null : switchboard.trim();
    }

    public void setStyle(String style) {
        this.style = style == null ? null : style.trim();
    }

    public void setSalespoint(String salespoint) {
        this.salespoint = salespoint == null ? null : salespoint.trim();
    }

    public void setOpentime(String opentime) {
        this.opentime = opentime == null ? null : opentime.trim();
    }

    public void setStar(String star) {
        this.star = star == null ? null : star.trim();
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public void setCheckinfo(String checkinfo) {
        this.checkinfo = checkinfo == null ? null : checkinfo.trim();
    }

    public void setChild(String child) {
        this.child = child == null ? null : child.trim();
    }

    public void setDiet(String diet) {
        this.diet = diet == null ? null : diet.trim();
    }

    public void setPet(String pet) {
        this.pet = pet == null ? null : pet.trim();
    }

    public void setWifi(String wifi) {
        this.wifi = wifi == null ? null : wifi.trim();
    }

    public void setWashsupply(String washsupply) {
        this.washsupply = washsupply == null ? null : washsupply.trim();
    }

    public void setAircondition(String aircondition) {
        this.aircondition = aircondition == null ? null : aircondition.trim();
    }

    public void setHotwater(String hotwater) {
        this.hotwater = hotwater == null ? null : hotwater.trim();
    }

    public void setBlower(String blower) {
        this.blower = blower == null ? null : blower.trim();
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant == null ? null : restaurant.trim();
    }

    public void setPark(String park) {
        this.park = park == null ? null : park.trim();
    }
}