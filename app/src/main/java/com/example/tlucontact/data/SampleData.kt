package com.example.tlucontact.data

object SampleData {
    private val _units = mutableListOf(
        OrgUnit(1, "Phòng Đào tạo", "123456789", "Tầng 1, Nhà A1"),
        OrgUnit(2, "Phòng Công tác sinh viên", "987654321", "Tầng 2, Nhà A1"),
        OrgUnit(3, "Phòng Hành chính - Tổng hợp", "111222333", "Tầng 3, Nhà A1"),
        OrgUnit(4, "Khoa Công nghệ thông tin", "222333444", "Tầng 4, Nhà A2"),
    )
    val units: List<OrgUnit> get() = _units

    private val _staff = mutableListOf(
        Staff(1, "Nguyễn Văn A", "Giảng viên", "0123456789", "a@tlu.edu.vn", "Khoa CNTT"),
        Staff(2, "Trần Thị B", "Nhân viên", "0987654321", "b@tlu.edu.vn", "Phòng HCTH"),
        Staff(3, "Lê Văn C", "Trưởng khoa", "0912345678", "c@tlu.edu.vn", "Khoa CNTT"),
        Staff(4, "Phạm Thị D", "Giảng viên", "0908765432", "d@tlu.edu.vn", "Khoa CNTT"),
        Staff(5, "Hoàng Văn E", "Nhân viên", "0923456789", "e@tlu.edu.vn", "Phòng Đào tạo"),
    )
    val staff: List<Staff> get() = _staff

    fun addUnit(newUnit: OrgUnit) {
        _units.add(newUnit)
    }

    fun addStaff(newStaff: Staff) {
        _staff.add(newStaff)
    }

    fun updateUnit(updatedUnit: OrgUnit) {
        val index = _units.indexOfFirst { it.id == updatedUnit.id }
        if (index != -1) {
            _units[index] = updatedUnit
        }
    }

    fun removeUnit(unitId: Int) {
        _units.removeAll { it.id == unitId }
    }

    fun updateStaff(updatedStaff: Staff) {
        val index = _staff.indexOfFirst { it.id == updatedStaff.id }
        if (index != -1) {
            _staff[index] = updatedStaff
        }
    }

    fun removeStaff(staffId: Int) {
        _staff.removeAll { it.id == staffId }
    }
}