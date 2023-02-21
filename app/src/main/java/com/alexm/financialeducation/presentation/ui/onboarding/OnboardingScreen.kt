package com.alexm.financialeducation.presentation.ui.onboarding

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import com.alexm.financialeducation.presentation.ui.compose.basecomponents.PrimaryButton
import com.alexm.financialeducation.presentation.ui.compose.basecomponents.SecondaryButton
import com.alexm.financialeducation.presentation.ui.compose.basecomponents.Toolbar
import com.alexm.financialeducation.presentation.ui.compose.theme.*
import com.alexm.financialeducation.data.dto.Onboarding
import com.alexm.financialeducation.presentation.viewmodel.FinancialEducationViewModel
import com.alexm.financialeducation.utils.FinancialEducationUtils
import com.alexm.financialeducation.utils.extensions.SetStatusBarColor

@Composable
fun OnboardingScreen(
    viewModel: FinancialEducationViewModel,
    onBackPressed: () -> Unit,
    onPrimaryBtnClick: () -> Unit,
    onSecondaryBtnClick: () -> Unit
){
    SetStatusBarColor()

    val onboardingState by viewModel.onboardingState.collectAsState()

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
    ) {
        val (image, title, message, buttons) = createRefs()
        val bottomGuideline = createGuidelineFromBottom(0.3f)
        val topGuideline = createGuidelineFromTop(0.60f)

        TopBar { onBackPressed() }

        OnboardingImage(
            modifier = Modifier.constrainAs(
                ref = image,
                constrainBlock = {
                    top.linkTo(parent.top)
                    bottom.linkTo(bottomGuideline)
                }
            ),
            resourceId = onboardingState.imageHeader
        )

        OnboardingHeader(
            modifier = Modifier.constrainAs(
                ref = title,
                constrainBlock = { top.linkTo(topGuideline) }
            ),
            text = stringResource(id = onboardingState.title)
        )

        OnboardingMessage(
            modifier = Modifier.constrainAs(
                ref = message,
                constrainBlock = { top.linkTo(title.bottom) }
            ),
            onboarding = onboardingState
        )

        OnboardingButtons(
            modifier = Modifier.constrainAs(
                ref = buttons,
                constrainBlock = { top.linkTo(message.bottom) }
            ),
            primaryBtnText = onboardingState.primaryBtnText,
            onPrimaryBtnClick = { onPrimaryBtnClick() },
            secondaryBtnText = onboardingState.secondaryBtnText,
            onSecondaryBtnClick = { onSecondaryBtnClick() }
        )
    }
}

@Composable
private fun TopBar(
    onBackPressed: () -> Unit
){
    Toolbar(
        backgroundColor = Color.Transparent,
        leftIconResource = R.drawable.ic_chevron_left_24px,
        iconTint = White, elevation = 0.dp,
        onLeftClick = onBackPressed
    )
}

@Composable
private fun OnboardingImage(
    modifier: Modifier,
    resourceId: Int
){
    Image(
        modifier = modifier
            .fillMaxWidth()
            .height(415.dp)
            .wrapContentHeight()
            .padding(horizontal = 16.dp),
        contentScale = ContentScale.Fit,
        painter = painterResource(id = resourceId),
        contentDescription = null
    )
}

@Composable
private fun OnboardingHeader(
    modifier: Modifier,
    text: String
){
    Text(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp),
        text = text,
        color = White,
        style = Typography.h1,
        textAlign = TextAlign.Center
    )
}

@Composable
private fun OnboardingMessage(
    modifier: Modifier,
    onboarding: Onboarding
){
    val styledMessage = FinancialEducationUtils.styledText(
        text = stringResource(id = onboarding.message),
        fontSize = 16.sp,
        color = White,
        normalColor = White,
        colorText = onboarding.boldText
    )

    Text(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 18.dp, vertical = 16.dp),
        text = styledMessage,
        color = White,
        style = Typography.subtitle2,
        textAlign = TextAlign.Center
    )
}

@Composable
private fun OnboardingButtons(
    modifier: Modifier,
    primaryBtnText: Int? = null,
    secondaryBtnText: Int? = null,
    onPrimaryBtnClick: () -> Unit = {},
    onSecondaryBtnClick: () -> Unit = {}
){
    val horizontalPadding = 18.dp

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(start = horizontalPadding, end = horizontalPadding, top = 42.dp)
    ) {
        secondaryBtnText?.let {
            SecondaryButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(42.dp),
                text = stringResource(id = it),
                contentColor = White,
                border = BorderStroke(1.dp, White),
                elevation = null,
                onClick = onSecondaryBtnClick
            )
        }

        primaryBtnText?.let {
            PrimaryButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(42.dp),
                text = stringResource(id = it),
                contentColor = Stori700Primary,
                backgroundColor = White,
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 0.dp,
                    pressedElevation = 0.dp
                ),
                onClick = onPrimaryBtnClick
            )
        }
    }
}