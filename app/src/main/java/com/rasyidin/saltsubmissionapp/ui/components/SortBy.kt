package com.rasyidin.saltsubmissionapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rasyidin.saltsubmissionapp.R
import com.rasyidin.saltsubmissionapp.domain.model.SortByProduct
import com.rasyidin.saltsubmissionapp.ui.theme.Gray100
import com.rasyidin.saltsubmissionapp.ui.theme.Gray50
import com.rasyidin.saltsubmissionapp.ui.theme.Gray900
import com.rasyidin.saltsubmissionapp.ui.theme.SaltSubmissionAppTheme
import com.rasyidin.saltsubmissionapp.ui.theme.firaSans

@Composable
fun SortBy(
    modifier: Modifier = Modifier,
    currentSort: SortByProduct = SortByProduct().setDefault(),
    sorts: List<SortByProduct>,
    onSortBySelected: (SortByProduct) -> Unit = {}
) {
    var expanded by remember { mutableStateOf(false) }
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_short),
            contentDescription = null,
            modifier = Modifier.size(12.dp),
            tint = Gray900
        )
        Spacer(Modifier.width(8.dp))
        Text(
            text = "Sort By:",
            fontFamily = firaSans,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            color = Gray900,
            modifier = Modifier.weight(1f)
        )
        Box(
            modifier = Modifier.wrapContentSize(Alignment.TopEnd)
        ) {
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .clickable {
                        expanded = true
                    }
                    .border(1.dp, Gray100, RoundedCornerShape(8.dp))
                    .background(Gray50)
                    .padding(horizontal = 14.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = currentSort.name,
                    fontFamily = firaSans,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Gray900
                )
                Spacer(Modifier.width(4.dp))
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_chevron),
                    contentDescription = null,
                    modifier = Modifier.size(18.dp),
                    tint = Gray900
                )
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.White)
            ) {
                sorts.forEachIndexed { index, sort ->
                    DropdownMenuItem(
                        text = {
                            Column(
                                modifier = Modifier.padding(14.dp)
                            ) {
                                val isLastIndex = index == sorts.lastIndex
                                Text(
                                    text = sort.name,
                                    fontFamily = firaSans,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 14.sp,
                                    color = Gray900
                                )
                                if (!isLastIndex) {
                                    Spacer(Modifier.height(14.dp))
                                    HorizontalDivider(
                                        thickness = 1.dp,
                                        color = Gray50
                                    )
                                }
                            }
                        },
                        onClick = {
                            onSortBySelected(sort)
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "Closed State")
@Composable
fun PreviewSortByClosed() {
    SaltSubmissionAppTheme {
        val mockSortOptions = listOf(
            SortByProduct(0, "Highest Price"),
            SortByProduct(1, "Lowest Price"),
            SortByProduct(2, "Name")
        )
        Surface(
            color = Color.White,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            SortBy(
                sorts = mockSortOptions,
                onSortBySelected = {}
            )
        }
    }
}

@Preview(showBackground = true, name = "Dropdown Item List")
@Composable
fun PreviewSortByExpanded() {
    SaltSubmissionAppTheme {
        val mockSortOptions = listOf(
            SortByProduct(0, "Highest Price"),
            SortByProduct(1, "Lowest Price"),
            SortByProduct(2, "Name")
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            SortBy(
                currentSort = SortByProduct(0,"Highest Price"),
                sorts = mockSortOptions
            )
        }
    }
}