package com.example.tlucontact.data

object SampleData {
    val units = listOf(
        OrgUnit("Phòng Đào tạo", "123456789", "Tầng 1, Nhà A1"),
        OrgUnit("Phòng Công tác sinh viên", "987654321", "Tầng 2, Nhà A1")
    )

    val staff = listOf(
        Staff("Nguyễn Văn A", "Giảng viên", "0123456789", "a@tlu.edu.vn", "Khoa CNTT"),
        Staff("Trần Thị B", "Nhân viên", "0987654321", "b@tlu.edu.vn", "Phòng HCTH")
    )
}