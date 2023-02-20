package com.alexm.financialeducation.presentation.ui.educationbanner

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.alexm.financialeducation.R
import com.alexm.financialeducation.presentation.ui.compose.basecomponents.*
import com.alexm.financialeducation.presentation.ui.compose.theme.*
import com.alexm.financialeducation.utils.FinancialEducationUtils.styledText
import com.alexm.financialeducation.utils.extensions.SetStatusBarColor

@Composable
fun EducationBannerScreen(
    onDismissPress: () -> Unit,
    onPrimaryBtnClick: () -> Unit,
    onSecondaryBtnClick: () -> Unit
) {
    SetStatusBarColor()

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        GreenGradient6,
                        GreenGradient7
                    )
                )
            )
            .statusBarsPadding()
            .verticalScroll(rememberScrollState())
    ) {
        val (topBar, image, card, buttons) = createRefs()
        //val topGuideline = createGuidelineFromTop(0.40f)

        TopBar(modifier = Modifier.constrainAs(
            ref = topBar,
            constrainBlock = { top.linkTo(parent.top) }
        )) { onDismissPress() }

        EducationBannerImage(
            modifier = Modifier.constrainAs(
                ref = image,
                constrainBlock = { top.linkTo(parent.top) }
            )
        )

        EducationBannerCard(
            modifier = Modifier.constrainAs(
                ref = card,
                constrainBlock = { top.linkTo(topBar.bottom) }
            )
        )

        EducationBannerButtons(
            modifier = Modifier.constrainAs(
                ref = buttons,
                constrainBlock = { top.linkTo(card.bottom) }
            ),
            onPrimaryBtnClick = { onPrimaryBtnClick() },
            onSecondaryBtnClick = { onSecondaryBtnClick() }
        )
    }
}

@Composable
private fun TopBar(
    modifier: Modifier,
    onDismissPress: () -> Unit
){
    Toolbar(
        modifier = modifier,
        backgroundColor = Color.Transparent,
        iconTint = White,
        elevation = 0.dp,
        rightIconResource = R.drawable.ic_close_16px,
        onRightIconClick = onDismissPress
    )
}

@Composable
private fun EducationBannerImage(
    modifier: Modifier
){
    Image(
        modifier = modifier.fillMaxWidth().height(292.dp).padding(top = 55.dp),
        contentScale = ContentScale.Fit,
        painter = painterResource(id = R.drawable.foco),
        contentDescription = null
    )
}

@Composable
private fun EducationBannerCard(
    modifier: Modifier
) {
    Card(modifier = modifier.fillMaxWidth().padding(horizontal = 16.dp).padding(top = 310.dp)) {
        Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 24.dp)) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.fe_banner_title),
                color = Stori700Primary,
                style = Typography.h3,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            val styledSubtitle = styledText(
                text = stringResource(id = R.string.fe_banner_subtitle),
                fontSize = 12.sp,
                color = Stori700Primary,
                colorText = listOf("Aprende con Stori.")

            )
            Text(
                modifier = modifier,
                text = styledSubtitle,
                textAlign = TextAlign.Center,
                lineHeight = 16.sp,
                letterSpacing = (0.3).sp
            )
            Spacer(modifier = Modifier.height(24.dp))
            EducationBannerIconText(
                resource = R.drawable.ic_smiling_face_with_sunglasses,
                pointTitle = R.string.fe_banner_first_point_title,
                pointContent = R.string.fe_banner_first_point_content
            )
            Spacer(modifier = Modifier.height(12.dp))
            EducationBannerIconText(
                resource = R.drawable.ic_selfie_light,
                pointTitle = R.string.fe_banner_second_point_title,
                pointContent = R.string.fe_banner_second_point_content
            )
        }
    }
}

@Composable
private fun EducationBannerIconText(
    @DrawableRes resource: Int,
    @StringRes pointTitle: Int,
    @StringRes pointContent: Int
){
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier.size(24.dp),
            painter = painterResource(id = resource),
            contentDescription = null
        )

        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(
                text = stringResource(id = pointTitle),
                color = Stori700Primary,
                style = Typography.subtitle3()
            )

            Text(
                text = stringResource(id = pointContent),
                color = Gray800,
                style = Typography.caption
            )
        }
    }
}

@Composable
private fun EducationBannerButtons(
    modifier: Modifier,
    onPrimaryBtnClick: () -> Unit = {},
    onSecondaryBtnClick: () -> Unit = {}
){
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        PrimaryButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(42.dp),
            text = stringResource(id = R.string.fe_banner_want_to_learn),
            contentColor = Stori700Primary,
            backgroundColor = White,
            elevation = ButtonDefaults.elevation(
                defaultElevation = 0.dp,
                pressedElevation = 0.dp
            ),
            onClick = onPrimaryBtnClick
        )

        BaseTextButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(42.dp),
            text = stringResource(id = R.string.fe_banner_do_it_latter),
            contentColor = White,
            elevation = null,
            onClick = onSecondaryBtnClick
        )
    }
}