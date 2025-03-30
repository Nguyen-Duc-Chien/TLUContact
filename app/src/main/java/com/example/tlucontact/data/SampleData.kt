package com.example.tlucontact.data

object SampleData {
    private val _units = mutableListOf(
        OrgUnit(1, "Phòng Đào tạo", "123456789", "Tầng 1, Nhà A1"),
        OrgUnit(2, "Phòng Công tác sinh viên", "987654321", "Tầng 2, Nhà A1"),
        OrgUnit(3, "Phòng Hành chính - Tổng hợp", "111222333", "Tầng 3, Nhà A1"),
        OrgUnit(4, "Khoa Công nghệ thông tin", "222333444", "Tầng 4, Nhà A2"),
        OrgUnit(5, "Khoa Kỹ thuật xây dựng", "333444555", "Tầng 5, Nhà A2"),
        OrgUnit(6, "Khoa Điện - Điện tử", "444555666", "Tầng 6, Nhà A2"),
        OrgUnit(7, "Khoa Kinh tế", "555666777", "Tầng 1, Nhà B1"),
        OrgUnit(8, "Khoa Môi trường", "666777888", "Tầng 2, Nhà B1"),
        OrgUnit(9, "Khoa Cơ khí", "777888999", "Tầng 3, Nhà B1"),
        OrgUnit(10, "Phòng Khoa học Công nghệ", "888999000", "Tầng 4, Nhà B1"),
        OrgUnit(11, "Phòng Đảm bảo chất lượng", "999000111", "Tầng 5, Nhà B1"),
        OrgUnit(12, "Phòng Quản lý Dự án", "000111222", "Tầng 6, Nhà B1"),
        OrgUnit(13, "Phòng Hợp tác Quốc tế", "111222333", "Tầng 1, Nhà C1"),
        OrgUnit(14, "Phòng Tài chính - Kế toán", "222333444", "Tầng 2, Nhà C1"),
        OrgUnit(15, "Trung tâm Tin học", "333444555", "Tầng 3, Nhà C1")
    )
    val units: List<OrgUnit> get() = _units

    private val _staff = mutableListOf(
        Staff(1, "Nguyễn Văn A", "Giảng viên", "0123456789", "a@tlu.edu.vn", "Khoa CNTT"),
        Staff(2, "Trần Thị B", "Nhân viên", "0987654321", "b@tlu.edu.vn", "Phòng HCTH"),
        Staff(3, "Lê Văn C", "Trưởng khoa", "0912345678", "c@tlu.edu.vn", "Khoa CNTT"),
        Staff(4, "Phạm Thị D", "Giảng viên", "0908765432", "d@tlu.edu.vn", "Khoa CNTT"),
        Staff(5, "Hoàng Văn E", "Nhân viên", "0923456789", "e@tlu.edu.vn", "Phòng Đào tạo"),
        Staff(6, "Đặng Thị F", "Chuyên viên", "0934567890", "f@tlu.edu.vn", "Phòng Đảm bảo chất lượng"),
        Staff(7, "Nguyễn Văn G", "Nhân viên", "0945678901", "g@tlu.edu.vn", "Phòng Hợp tác Quốc tế"),
        Staff(8, "Bùi Thị H", "Nhân viên", "0956789012", "h@tlu.edu.vn", "Phòng Tài chính - Kế toán"),
        Staff(9, "Nguyễn Văn I", "Trưởng phòng", "0967890123", "i@tlu.edu.vn", "Phòng Khoa học Công nghệ"),
        Staff(10, "Phan Thị K", "Giảng viên", "0978901234", "k@tlu.edu.vn", "Khoa Kinh tế"),
        Staff(11, "Lý Văn M", "Chuyên viên", "0989012345", "m@tlu.edu.vn", "Khoa Kỹ thuật xây dựng"),
        Staff(12, "Đỗ Thị N", "Nhân viên", "0990123456", "n@tlu.edu.vn", "Khoa Điện - Điện tử"),
        Staff(13, "Vũ Văn O", "Nhân viên", "0901234567", "o@tlu.edu.vn", "Khoa Cơ khí"),
        Staff(14, "Trịnh Thị P", "Giảng viên", "0912345678", "p@tlu.edu.vn", "Khoa Môi trường"),
        Staff(15, "Phạm Văn Q", "Chuyên viên", "0923456789", "q@tlu.edu.vn", "Phòng Quản lý Dự án"),
        Staff(16, "Trần Thị R", "Nhân viên", "0934567890", "r@tlu.edu.vn", "Phòng Công tác sinh viên"),
        Staff(17, "Nguyễn Văn S", "Giảng viên", "0945678901", "s@tlu.edu.vn", "Khoa CNTT"),
        Staff(18, "Đỗ Thị T", "Chuyên viên", "0956789012", "t@tlu.edu.vn", "Trung tâm Tin học"),
        Staff(19, "Bùi Văn U", "Nhân viên", "0967890123", "u@tlu.edu.vn", "Khoa CNTT"),
        Staff(20, "Lê Thị V", "Trưởng khoa", "0978901234", "v@tlu.edu.vn", "Khoa Kinh tế"),
        Staff(21, "Hoàng Văn W", "Nhân viên", "0989012345", "w@tlu.edu.vn", "Khoa Môi trường"),
        Staff(22, "Phan Thị X", "Nhân viên", "0990123456", "x@tlu.edu.vn", "Phòng Công tác sinh viên"),
        Staff(23, "Vũ Văn Y", "Giảng viên", "0901234567", "y@tlu.edu.vn", "Khoa Kỹ thuật xây dựng"),
        Staff(24, "Trịnh Thị Z", "Chuyên viên", "0912345678", "z@tlu.edu.vn", "Phòng Quản lý Dự án"),
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