package ua.nure.makieiev.ark.model.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "points_config")
data class PointConfig(@Id
                       @GeneratedValue(strategy = GenerationType.IDENTITY)
                       @Column(name = "Id_point_config")
                       var id: Long? = null,
                       @Column(name = "Default_points")
                       var defaultPoints: Int? = null,
                       @Column(name = "Extra_points")
                       var extraPoints: Int? = null
)