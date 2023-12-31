USE [MILK_TEA]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 7/30/2023 4:52:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[uID] [int] IDENTITY(1,1) NOT NULL,
	[user] [varchar](255) NULL,
	[pass] [varchar](255) NULL,
	[isSell] [int] NULL,
	[isAdmin] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[uID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Cart]    Script Date: 7/30/2023 4:52:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cart](
	[AccountID] [int] NULL,
	[ProductID] [int] NULL,
	[Amount] [int] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Category]    Script Date: 7/30/2023 4:52:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[cid] [int] NOT NULL,
	[cname] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Category] PRIMARY KEY CLUSTERED 
(
	[cid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[product]    Script Date: 7/30/2023 4:52:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[product](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](max) NULL,
	[image] [nvarchar](max) NULL,
	[price] [money] NULL,
	[title] [nvarchar](max) NULL,
	[description] [nvarchar](max) NULL,
	[cateID] [int] NULL,
	[sell_ID] [int] NULL,
	[BC_ID] [int] NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Account] ON 

INSERT [dbo].[Account] ([uID], [user], [pass], [isSell], [isAdmin]) VALUES (1, N'Khang1904', N'1904', 1, 0)
INSERT [dbo].[Account] ([uID], [user], [pass], [isSell], [isAdmin]) VALUES (2, N'Tung0411', N'0411', 1, 0)
SET IDENTITY_INSERT [dbo].[Account] OFF
GO
INSERT [dbo].[Category] ([cid], [cname]) VALUES (1, N'Trà Sữa ')
INSERT [dbo].[Category] ([cid], [cname]) VALUES (2, N'Trà Sữa Đặc Biệt')
GO
SET IDENTITY_INSERT [dbo].[product] ON 

INSERT [dbo].[product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID], [BC_ID]) VALUES (1, N'Trà Sữa Bí Ðaoa', N'http://store.bobapop.com.vn/resource/uploads/2019/06/03-Ts-Bi-Dao.jpg', 60.6000, N'Trà ', N'Trà ', 1, 1, 1)
INSERT [dbo].[product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID], [BC_ID]) VALUES (9, N'Trà Sữa Kiwii', N'http://store.bobapop.com.vn/resource/uploads/2019/06/14-Ts-Kiwi.jpg', 32.0000, N'qqq', N'aaaa', 1, 1, 1)
INSERT [dbo].[product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID], [BC_ID]) VALUES (3, N'Trà Sữa Dâu Tây', N'http://store.bobapop.com.vn/resource/uploads/2019/06/05-Ts-Dau.jpg', 29.0000, N'Trà Sữa ', N'Trà ', 1, 1, 1)
INSERT [dbo].[product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID], [BC_ID]) VALUES (4, N'Trà Sữa Ô Long', N'http://store.bobapop.com.vn/resource/uploads/2019/06/17-Ts-oolong.jpg', 32.0000, N'Trà Sữa Đặc Biệt', N'Trà ', 2, 2, 1)
INSERT [dbo].[product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID], [BC_ID]) VALUES (5, N'Trà Sữa Gạo Nâu', N'http://store.bobapop.com.vn/resource/uploads/2019/06/22-Tra-Gao.jpg', 32.0000, N'Trà Sữa Đặc Biệt', N'Trà ', 2, 2, 1)
INSERT [dbo].[product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID], [BC_ID]) VALUES (6, N'Trà Sữa Vải', N'http://store.bobapop.com.vn/resource/uploads/2019/06/02-Ts-Vai.jpg', 29.0000, N'Trà Sữa ', N'Trà ', 1, 1, 1)
INSERT [dbo].[product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID], [BC_ID]) VALUES (7, N'Trà Sữa Bạc Hà
', N'http://store.bobapop.com.vn/resource/uploads/2019/06/12-Ts-Bac-Ha.jpg', 32.0000, N'Trà Sữa Đặc Biệt', N'Trà ', 2, 2, 1)
INSERT [dbo].[product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID], [BC_ID]) VALUES (10, N'Sữa Tươi Trân Châu Đường Đen', N'http://store.bobapop.com.vn/resource/uploads/2019/06/30-sua-tuoi-tran-chau.jpg', 32.0000, N'Quá Ngon ', N'Ngon Lắm', 2, 1, 1)
INSERT [dbo].[product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID], [BC_ID]) VALUES (12, N'Trà Sữa Khoai Môn', N'http://store.bobapop.com.vn/resource/uploads/2019/06/07-Ts-Khoai-mon-600x600.jpg', 32.0000, N'Ngon lứm', N'Trà Sữa', 1, 1, 1)
INSERT [dbo].[product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID], [BC_ID]) VALUES (13, N'Trà Quan Âm Sủi Bọt', N'http://store.bobapop.com.vn/resource/uploads/2019/06/09-Quan-Am-Sb-600x600.jpg', 42.0000, N'Sản Phẩm mới', N'Ngon ', 1, 2, 1)
INSERT [dbo].[product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID], [BC_ID]) VALUES (14, N' Kem Tuyết Sôcôla', N'http://store.bobapop.com.vn/resource/uploads/2019/06/05-Socola-600x600.jpg', 38.0000, N'Loại mới ra', N'Thơm ngon ', 2, 2, 1)
INSERT [dbo].[product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID], [BC_ID]) VALUES (15, N'Trà Xanh Kiwi', N'http://store.bobapop.com.vn/resource/uploads/2019/06/14-Kiwi.jpg', 42.0000, N'Tra', N'cccc', 2, 1, 1)
INSERT [dbo].[product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID], [BC_ID]) VALUES (29, N'Trà Raspberry', N'http://store.bobapop.com.vn/resource/uploads/2019/06/16-Dau-Rung-300x300.jpg', 38.0000, N'aa', N'aa', 1, 1, NULL)
INSERT [dbo].[product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID], [BC_ID]) VALUES (8, N'Chocominz', N'http://store.bobapop.com.vn/resource/uploads/2019/06/31-Chocominz.jpg', 38.0000, N'Trà Sữa Đặc Biệt', N'Trà ', 2, 2, 1)
INSERT [dbo].[product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID], [BC_ID]) VALUES (25, N'Hồng Trà Sủi Bọt', N'http://store.bobapop.com.vn/resource/uploads/2019/06/03-Hong-tra-sb.jpg', 32.0000, N'aa', N'aaa', 1, 1, 1)
INSERT [dbo].[product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID], [BC_ID]) VALUES (26, N'Trà Bí Đao Sủi Bọt', N'http://store.bobapop.com.vn/resource/uploads/2019/06/30-sua-tuoi-tran-chau.jpg', 32.0000, N'a', N'a', 1, 1, 1)
SET IDENTITY_INSERT [dbo].[product] OFF
GO
