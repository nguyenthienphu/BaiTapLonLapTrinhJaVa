/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntp.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
<<<<<<< HEAD
import javax.validation.constraints.Max;
=======
>>>>>>> 77fcc7b57d1f14a810b7d9b9b4db1cb93543db0a
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
@Entity
@Data
@Table(name = "room")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Room.findAll", query = "SELECT r FROM Room r"),
    @NamedQuery(name = "Room.findById", query = "SELECT r FROM Room r WHERE r.id = :id"),
    @NamedQuery(name = "Room.findByName", query = "SELECT r FROM Room r WHERE r.name = :name"),
    @NamedQuery(name = "Room.findByDescription", query = "SELECT r FROM Room r WHERE r.description = :description"),
    @NamedQuery(name = "Room.findByPrice", query = "SELECT r FROM Room r WHERE r.price = :price"),
    @NamedQuery(name = "Room.findByNumber", query = "SELECT r FROM Room r WHERE r.number = :number"),
    @NamedQuery(name = "Room.findByImage", query = "SELECT r FROM Room r WHERE r.image = :image"),
    @NamedQuery(name = "Room.findByCreatedDate", query = "SELECT r FROM Room r WHERE r.createdDate = :createdDate"),
    @NamedQuery(name = "Room.findByActive", query = "SELECT r FROM Room r WHERE r.active = :active")})
public class Room implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
<<<<<<< HEAD
    @Size(min = 5 ,max = 45 , message = "{room.name.lenErr}")
=======
    @Size(min = 5, max = 50 , message = "{room.name.lenErr}")
>>>>>>> 77fcc7b57d1f14a810b7d9b9b4db1cb93543db0a
    @NotNull(message = "{room.name.notNull}")
    private String name;
    @Size(min=10,max = 255, message = "{room.des.lenErr}")
    @Column(name = "description")
    private String description;
<<<<<<< HEAD
    @Size(min = 10, max = 100 , message = "{address.lenErr}")
    @NotNull(message = "{notNull}")
=======
    @Size(min = 10 , max = 200, message = "{room.addRess.lenErr}")
    @NotNull(message = "room.addRess.notNull")
>>>>>>> 77fcc7b57d1f14a810b7d9b9b4db1cb93543db0a
    @Column(name = "address")
    private String address;
    @Column(name = "price")
    
    @Min(value = 1000000, message = "{price.lenErr}")
    @Max(value = 5000000, message = "{price.lenErr}")
    private Long price;
    @Column(name = "number")
    private Integer number;
    @Size(max = 200)
    @Column(name = "image")
    private String image;
    
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "active")
    private Boolean active;
    @JoinColumn(name = "host_id", referencedColumnName = "id")
    @ManyToOne
    @JsonIgnore
    private Host hostId;
    @OneToMany(mappedBy = "room")
    @JsonIgnore
    private Set<Comment> commentSet;
    
    @Transient
    @JsonIgnore
    private MultipartFile file;

    public Room() {
    }

    public Room(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
     public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Host getHostId() {
        return hostId;
    }

    public void setHostId(Host hostId) {
        this.hostId = hostId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Room)) {
            return false;
        }
        Room other = (Room) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ntp.pojo.Room[ id=" + id + " ]";
    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }
    
}
