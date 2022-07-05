/*!
 * Copyright © 2022 uyawer. All rights Reserved.
 */

package com.uyawer.portal.helper

import com.google.common.collect.Lists
import com.uyawer.portal.model.dto.EmployeeDto
import com.uyawer.portal.model.entity.EmployeeEntity
import spock.lang.Specification
import spock.lang.Unroll

import java.time.LocalDate

@Unroll
class EmployeesHelperTest extends Specification {

  def "entityListをdtoListに変換する"() {
    setup:
    def target = new EmployeesHelper()

    when:
    def result = target.convertDtoList(employees)

    then:
    result == actual

    where:
    employees = [
      new EmployeeEntity(id: 1, number: "0210000", loginId: "admin_a", lastName: "管理者", firstName: "A", password: "\$2a\$10\$BVugqASEdKPIIiOOPQEkXONl9N7kAyKLEpMd8mjPpMUKK2zRgxcfq", position: null, departmentId: null, roleId: 1, birthday: null, retirementFlg: false),
      new EmployeeEntity(id: 2, number: "0210001", loginId: "admin_b", lastName: "管理者", firstName: "B", password: "\$2a\$10\$BVugqASEdKPIIiOOPQEkXONl9N7kAyKLEpMd8mjPpMUKK2zRgxcfq", position: null, departmentId: null, roleId: 2, birthday: null, retirementFlg: false),
      new EmployeeEntity(id: 3, number: "0210002", loginId: "admin_c", lastName: "管理者", firstName: "C", password: "\$2a\$10\$BVugqASEdKPIIiOOPQEkXONl9N7kAyKLEpMd8mjPpMUKK2zRgxcfq", position: null, departmentId: null, roleId: 3, birthday: null, retirementFlg: false),
      new EmployeeEntity(id: 4, number: "0210101", loginId: "user101", lastName: "山田", firstName: "太郎", password: "\$2a\$10\$BVugqASEdKPIIiOOPQEkXONl9N7kAyKLEpMd8mjPpMUKK2zRgxcfq", position: null, departmentId: 3, roleId: 4, birthday: LocalDate.of(1983, 2, 28), retirementFlg: false),
      new EmployeeEntity(id: 5, number: "0210102", loginId: "user102", lastName: "山田", firstName: "治郎", password: "\$2a\$10\$BVugqASEdKPIIiOOPQEkXONl9N7kAyKLEpMd8mjPpMUKK2zRgxcfq", position: null, departmentId: 3, roleId: 5, birthday: LocalDate.of(1971, 7, 30), retirementFlg: false),
      new EmployeeEntity(id: 6, number: "0210103", loginId: "user103", lastName: "山田", firstName: "左武郎", password: "\$2a\$10\$BVugqASEdKPIIiOOPQEkXONl9N7kAyKLEpMd8mjPpMUKK2zRgxcfq", position: null, departmentId: 3, roleId: 6, birthday: LocalDate.of(2000, 1, 14), retirementFlg: false),
      new EmployeeEntity(id: 7, number: "0210104", loginId: "user104", lastName: "山田", firstName: "士郎", password: "\$2a\$10\$BVugqASEdKPIIiOOPQEkXONl9N7kAyKLEpMd8mjPpMUKK2zRgxcfq", position: null, departmentId: 2, roleId: 7, birthday: null, retirementFlg: false),
      new EmployeeEntity(id: 8, number: "0210105", loginId: "user105", lastName: "山田", firstName: "吾郎", password: "\$2a\$10\$BVugqASEdKPIIiOOPQEkXONl9N7kAyKLEpMd8mjPpMUKK2zRgxcfq", position: null, departmentId: null, roleId: 8, birthday: LocalDate.of(1986, 3, 31), retirementFlg: false)
    ]
    actual = [
      new EmployeeDto(new EmployeeEntity(id: 1, number: "0210000", loginId: "admin_a", lastName: "管理者", firstName: "A", password: "\$2a\$10\$BVugqASEdKPIIiOOPQEkXONl9N7kAyKLEpMd8mjPpMUKK2zRgxcfq", position: null, departmentId: null, roleId: 1, birthday: null, retirementFlg: false)),
      new EmployeeDto(new EmployeeEntity(id: 2, number: "0210001", loginId: "admin_b", lastName: "管理者", firstName: "B", password: "\$2a\$10\$BVugqASEdKPIIiOOPQEkXONl9N7kAyKLEpMd8mjPpMUKK2zRgxcfq", position: null, departmentId: null, roleId: 2, birthday: null, retirementFlg: false)),
      new EmployeeDto(new EmployeeEntity(id: 3, number: "0210002", loginId: "admin_c", lastName: "管理者", firstName: "C", password: "\$2a\$10\$BVugqASEdKPIIiOOPQEkXONl9N7kAyKLEpMd8mjPpMUKK2zRgxcfq", position: null, departmentId: null, roleId: 3, birthday: null, retirementFlg: false)),
      new EmployeeDto(new EmployeeEntity(id: 4, number: "0210101", loginId: "user101", lastName: "山田", firstName: "太郎", password: "\$2a\$10\$BVugqASEdKPIIiOOPQEkXONl9N7kAyKLEpMd8mjPpMUKK2zRgxcfq", position: null, departmentId: 3, roleId: 4, birthday: LocalDate.of(1983, 2, 28), retirementFlg: false)),
      new EmployeeDto(new EmployeeEntity(id: 5, number: "0210102", loginId: "user102", lastName: "山田", firstName: "治郎", password: "\$2a\$10\$BVugqASEdKPIIiOOPQEkXONl9N7kAyKLEpMd8mjPpMUKK2zRgxcfq", position: null, departmentId: 3, roleId: 5, birthday: LocalDate.of(1971, 7, 30), retirementFlg: false)),
      new EmployeeDto(new EmployeeEntity(id: 6, number: "0210103", loginId: "user103", lastName: "山田", firstName: "左武郎", password: "\$2a\$10\$BVugqASEdKPIIiOOPQEkXONl9N7kAyKLEpMd8mjPpMUKK2zRgxcfq", position: null, departmentId: 3, roleId: 6, birthday: LocalDate.of(2000, 1, 14), retirementFlg: false)),
      new EmployeeDto(new EmployeeEntity(id: 7, number: "0210104", loginId: "user104", lastName: "山田", firstName: "士郎", password: "\$2a\$10\$BVugqASEdKPIIiOOPQEkXONl9N7kAyKLEpMd8mjPpMUKK2zRgxcfq", position: null, departmentId: 2, roleId: 7, birthday: null, retirementFlg: false)),
      new EmployeeDto(new EmployeeEntity(id: 8, number: "0210105", loginId: "user105", lastName: "山田", firstName: "吾郎", password: "\$2a\$10\$BVugqASEdKPIIiOOPQEkXONl9N7kAyKLEpMd8mjPpMUKK2zRgxcfq", position: null, departmentId: null, roleId: 8, birthday: LocalDate.of(1986, 3, 31), retirementFlg: false))
    ]
  }

  def "entityをdtoListに変換する"() {
    setup:
    def target = new EmployeesHelper()

    when:
    def result = target.convertDtoList(employees)

    then:
    result == actual

    where:
    employees || actual
    new EmployeeEntity(id: 1, number: "0210000", loginId: "admin_a", lastName: "管理者", firstName: "A", password: "\$2a\$10\$BVugqASEdKPIIiOOPQEkXONl9N7kAyKLEpMd8mjPpMUKK2zRgxcfq", position: null, departmentId: null, roleId: 1, birthday: null, retirementFlg: false)
              || Lists.newArrayList(new EmployeeDto(new EmployeeEntity(id: 1, number: "0210000", loginId: "admin_a", lastName: "管理者", firstName: "A", password: "\$2a\$10\$BVugqASEdKPIIiOOPQEkXONl9N7kAyKLEpMd8mjPpMUKK2zRgxcfq", position: null, departmentId: null, roleId: 1, birthday: null, retirementFlg: false)))
    new EmployeeEntity(id: 2, number: "0210001", loginId: "admin_b", lastName: "管理者", firstName: "B", password: "\$2a\$10\$BVugqASEdKPIIiOOPQEkXONl9N7kAyKLEpMd8mjPpMUKK2zRgxcfq", position: null, departmentId: null, roleId: 2, birthday: null, retirementFlg: false)
              || Lists.newArrayList(new EmployeeDto(new EmployeeEntity(id: 2, number: "0210001", loginId: "admin_b", lastName: "管理者", firstName: "B", password: "\$2a\$10\$BVugqASEdKPIIiOOPQEkXONl9N7kAyKLEpMd8mjPpMUKK2zRgxcfq", position: null, departmentId: null, roleId: 2, birthday: null, retirementFlg: false)))
    new EmployeeEntity(id: 3, number: "0210002", loginId: "admin_c", lastName: "管理者", firstName: "C", password: "\$2a\$10\$BVugqASEdKPIIiOOPQEkXONl9N7kAyKLEpMd8mjPpMUKK2zRgxcfq", position: null, departmentId: null, roleId: 3, birthday: null, retirementFlg: false)
              || Lists.newArrayList(new EmployeeDto(new EmployeeEntity(id: 3, number: "0210002", loginId: "admin_c", lastName: "管理者", firstName: "C", password: "\$2a\$10\$BVugqASEdKPIIiOOPQEkXONl9N7kAyKLEpMd8mjPpMUKK2zRgxcfq", position: null, departmentId: null, roleId: 3, birthday: null, retirementFlg: false)))
    new EmployeeEntity(id: 4, number: "0210101", loginId: "user101", lastName: "山田", firstName: "太郎", password: "\$2a\$10\$BVugqASEdKPIIiOOPQEkXONl9N7kAyKLEpMd8mjPpMUKK2zRgxcfq", position: null, departmentId: 3, roleId: 4, birthday: LocalDate.of(1983, 2, 28), retirementFlg: false)
              || Lists.newArrayList(new EmployeeDto(new EmployeeEntity(id: 4, number: "0210101", loginId: "user101", lastName: "山田", firstName: "太郎", password: "\$2a\$10\$BVugqASEdKPIIiOOPQEkXONl9N7kAyKLEpMd8mjPpMUKK2zRgxcfq", position: null, departmentId: 3, roleId: 4, birthday: LocalDate.of(1983, 2, 28), retirementFlg: false)))
    new EmployeeEntity(id: 5, number: "0210102", loginId: "user102", lastName: "山田", firstName: "治郎", password: "\$2a\$10\$BVugqASEdKPIIiOOPQEkXONl9N7kAyKLEpMd8mjPpMUKK2zRgxcfq", position: null, departmentId: 3, roleId: 5, birthday: LocalDate.of(1971, 7, 30), retirementFlg: false)
              || Lists.newArrayList(new EmployeeDto(new EmployeeEntity(id: 5, number: "0210102", loginId: "user102", lastName: "山田", firstName: "治郎", password: "\$2a\$10\$BVugqASEdKPIIiOOPQEkXONl9N7kAyKLEpMd8mjPpMUKK2zRgxcfq", position: null, departmentId: 3, roleId: 5, birthday: LocalDate.of(1971, 7, 30), retirementFlg: false)))
    new EmployeeEntity(id: 6, number: "0210103", loginId: "user103", lastName: "山田", firstName: "左武郎", password: "\$2a\$10\$BVugqASEdKPIIiOOPQEkXONl9N7kAyKLEpMd8mjPpMUKK2zRgxcfq", position: null, departmentId: 3, roleId: 6, birthday: LocalDate.of(2000, 1, 14), retirementFlg: false)
              || Lists.newArrayList(new EmployeeDto(new EmployeeEntity(id: 6, number: "0210103", loginId: "user103", lastName: "山田", firstName: "左武郎", password: "\$2a\$10\$BVugqASEdKPIIiOOPQEkXONl9N7kAyKLEpMd8mjPpMUKK2zRgxcfq", position: null, departmentId: 3, roleId: 6, birthday: LocalDate.of(2000, 1, 14), retirementFlg: false)))
    new EmployeeEntity(id: 7, number: "0210104", loginId: "user104", lastName: "山田", firstName: "士郎", password: "\$2a\$10\$BVugqASEdKPIIiOOPQEkXONl9N7kAyKLEpMd8mjPpMUKK2zRgxcfq", position: null, departmentId: 2, roleId: 7, birthday: null, retirementFlg: false)
              || Lists.newArrayList(new EmployeeDto(new EmployeeEntity(id: 7, number: "0210104", loginId: "user104", lastName: "山田", firstName: "士郎", password: "\$2a\$10\$BVugqASEdKPIIiOOPQEkXONl9N7kAyKLEpMd8mjPpMUKK2zRgxcfq", position: null, departmentId: 2, roleId: 7, birthday: null, retirementFlg: false)))
    new EmployeeEntity(id: 8, number: "0210105", loginId: "user105", lastName: "山田", firstName: "吾郎", password: "\$2a\$10\$BVugqASEdKPIIiOOPQEkXONl9N7kAyKLEpMd8mjPpMUKK2zRgxcfq", position: null, departmentId: null, roleId: 8, birthday: LocalDate.of(1986, 3, 31), retirementFlg: false)
              || Lists.newArrayList(new EmployeeDto(new EmployeeEntity(id: 8, number: "0210105", loginId: "user105", lastName: "山田", firstName: "吾郎", password: "\$2a\$10\$BVugqASEdKPIIiOOPQEkXONl9N7kAyKLEpMd8mjPpMUKK2zRgxcfq", position: null, departmentId: null, roleId: 8, birthday: LocalDate.of(1986, 3, 31), retirementFlg: false)))
  }

  def "entityをdtoに変換する"() {
    setup:
    def target = new EmployeesHelper()

    when:
    def result = target.convertDto(employees)

    then:
    result == actual

    where:
    employees || actual
    new EmployeeEntity(id: 1, number: "0210000", loginId: "admin_a", lastName: "管理者", firstName: "A", password: "\$2a\$10\$BVugqASEdKPIIiOOPQEkXONl9N7kAyKLEpMd8mjPpMUKK2zRgxcfq", position: null, departmentId: null, roleId: 1, birthday: null, retirementFlg: false)
              || new EmployeeDto(new EmployeeEntity(id: 1, number: "0210000", loginId: "admin_a", lastName: "管理者", firstName: "A", password: "\$2a\$10\$BVugqASEdKPIIiOOPQEkXONl9N7kAyKLEpMd8mjPpMUKK2zRgxcfq", position: null, departmentId: null, roleId: 1, birthday: null, retirementFlg: false))
    new EmployeeEntity(id: 2, number: "0210001", loginId: "admin_b", lastName: "管理者", firstName: "B", password: "\$2a\$10\$BVugqASEdKPIIiOOPQEkXONl9N7kAyKLEpMd8mjPpMUKK2zRgxcfq", position: null, departmentId: null, roleId: 2, birthday: null, retirementFlg: false)
              || new EmployeeDto(new EmployeeEntity(id: 2, number: "0210001", loginId: "admin_b", lastName: "管理者", firstName: "B", password: "\$2a\$10\$BVugqASEdKPIIiOOPQEkXONl9N7kAyKLEpMd8mjPpMUKK2zRgxcfq", position: null, departmentId: null, roleId: 2, birthday: null, retirementFlg: false))
    new EmployeeEntity(id: 3, number: "0210002", loginId: "admin_c", lastName: "管理者", firstName: "C", password: "\$2a\$10\$BVugqASEdKPIIiOOPQEkXONl9N7kAyKLEpMd8mjPpMUKK2zRgxcfq", position: null, departmentId: null, roleId: 3, birthday: null, retirementFlg: false)
              || new EmployeeDto(new EmployeeEntity(id: 3, number: "0210002", loginId: "admin_c", lastName: "管理者", firstName: "C", password: "\$2a\$10\$BVugqASEdKPIIiOOPQEkXONl9N7kAyKLEpMd8mjPpMUKK2zRgxcfq", position: null, departmentId: null, roleId: 3, birthday: null, retirementFlg: false))
    new EmployeeEntity(id: 4, number: "0210101", loginId: "user101", lastName: "山田", firstName: "太郎", password: "\$2a\$10\$BVugqASEdKPIIiOOPQEkXONl9N7kAyKLEpMd8mjPpMUKK2zRgxcfq", position: null, departmentId: 3, roleId: 4, birthday: LocalDate.of(1983, 2, 28), retirementFlg: false)
              || new EmployeeDto(new EmployeeEntity(id: 4, number: "0210101", loginId: "user101", lastName: "山田", firstName: "太郎", password: "\$2a\$10\$BVugqASEdKPIIiOOPQEkXONl9N7kAyKLEpMd8mjPpMUKK2zRgxcfq", position: null, departmentId: 3, roleId: 4, birthday: LocalDate.of(1983, 2, 28), retirementFlg: false))
    new EmployeeEntity(id: 5, number: "0210102", loginId: "user102", lastName: "山田", firstName: "治郎", password: "\$2a\$10\$BVugqASEdKPIIiOOPQEkXONl9N7kAyKLEpMd8mjPpMUKK2zRgxcfq", position: null, departmentId: 3, roleId: 5, birthday: LocalDate.of(1971, 7, 30), retirementFlg: false)
              || new EmployeeDto(new EmployeeEntity(id: 5, number: "0210102", loginId: "user102", lastName: "山田", firstName: "治郎", password: "\$2a\$10\$BVugqASEdKPIIiOOPQEkXONl9N7kAyKLEpMd8mjPpMUKK2zRgxcfq", position: null, departmentId: 3, roleId: 5, birthday: LocalDate.of(1971, 7, 30), retirementFlg: false))
    new EmployeeEntity(id: 6, number: "0210103", loginId: "user103", lastName: "山田", firstName: "左武郎", password: "\$2a\$10\$BVugqASEdKPIIiOOPQEkXONl9N7kAyKLEpMd8mjPpMUKK2zRgxcfq", position: null, departmentId: 3, roleId: 6, birthday: LocalDate.of(2000, 1, 14), retirementFlg: false)
              || new EmployeeDto(new EmployeeEntity(id: 6, number: "0210103", loginId: "user103", lastName: "山田", firstName: "左武郎", password: "\$2a\$10\$BVugqASEdKPIIiOOPQEkXONl9N7kAyKLEpMd8mjPpMUKK2zRgxcfq", position: null, departmentId: 3, roleId: 6, birthday: LocalDate.of(2000, 1, 14), retirementFlg: false))
    new EmployeeEntity(id: 7, number: "0210104", loginId: "user104", lastName: "山田", firstName: "士郎", password: "\$2a\$10\$BVugqASEdKPIIiOOPQEkXONl9N7kAyKLEpMd8mjPpMUKK2zRgxcfq", position: null, departmentId: 2, roleId: 7, birthday: null, retirementFlg: false)
              || new EmployeeDto(new EmployeeEntity(id: 7, number: "0210104", loginId: "user104", lastName: "山田", firstName: "士郎", password: "\$2a\$10\$BVugqASEdKPIIiOOPQEkXONl9N7kAyKLEpMd8mjPpMUKK2zRgxcfq", position: null, departmentId: 2, roleId: 7, birthday: null, retirementFlg: false))
    new EmployeeEntity(id: 8, number: "0210105", loginId: "user105", lastName: "山田", firstName: "吾郎", password: "\$2a\$10\$BVugqASEdKPIIiOOPQEkXONl9N7kAyKLEpMd8mjPpMUKK2zRgxcfq", position: null, departmentId: null, roleId: 8, birthday: LocalDate.of(1986, 3, 31), retirementFlg: false)
              || new EmployeeDto(new EmployeeEntity(id: 8, number: "0210105", loginId: "user105", lastName: "山田", firstName: "吾郎", password: "\$2a\$10\$BVugqASEdKPIIiOOPQEkXONl9N7kAyKLEpMd8mjPpMUKK2zRgxcfq", position: null, departmentId: null, roleId: 8, birthday: LocalDate.of(1986, 3, 31), retirementFlg: false))
  }
}
