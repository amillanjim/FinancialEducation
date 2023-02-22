package com.alexm.financialeducation.presentation.ui.onboarding

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.alexm.financialeducation.R
import com.alexm.financialeducation.presentation.ui.compose.basecomponents.PrimaryButton
import com.alexm.financialeducation.presentation.ui.compose.basecomponents.SecondaryButton
import com.alexm.financialeducation.presentation.ui.compose.basecomponents.Toolbar
import com.alexm.financialeducation.presentation.ui.compose.theme.*
import com.alexm.financialeducation.data.dto.Onboarding
import com.alexm.financialeducation.presentation.ui.compose.basecomponents.SetSystemBarsColor
import com.alexm.financialeducation.presentation.viewmodel.FinancialEducationViewModel
import com.alexm.financialeducation.utils.extensions.onboardingContainer
import com.alexm.financialeducation.utils.extensions.setStyle
import com.alexm.financialeducation.utils.extensions.styledText

@Composable
fun OnboardingScreen(
    viewModel: FinancialEducationViewModel,
    onBackPressed: () -> Unit,
    onPrimaryBtnClick: () -> Unit,
    onSecondaryBtnClick: () -> Unit
){
    BackHandler { onBackPressed() }

    SetSystemBarsColor()

    val onboardingState by viewModel.onboardingState.collectAsState()

    ConstraintLayout(
        modifier = Modifier.onboardingContainer()
    ) {
        val (toolbar, image, title, message, buttons) = createRefs()

        TopBar(modifier = Modifier.constrainAs(
            ref = toolbar,
            constrainBlock = { top.linkTo(parent.top) }
        )) { onBackPressed() }

        OnboardingImage(
            modifier = Modifier.constrainAs(
                ref = image,
                constrainBlock = { top.linkTo(toolbar.bottom) }
            ),
            resourceId = onboardingState.imageHeader,
            rotateImage = onboardingState.rotateImage,
            contentScale = onboardingState.contentScale
        )

        OnboardingHeader(
            modifier = Modifier.constrainAs(
                ref = title,
                constrainBlock = { top.linkTo(image.bottom) }
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
    modifier: Modifier,
    onBackPressed: () -> Unit
){
    Toolbar(
        modifier = modifier,
        backgroundColor = Color.Transparent,
        leftIconResource = R.drawable.ic_chevron_left_24px,
        iconTint = White, elevation = 0.dp,
        onLeftClick = onBackPressed
    )
}

@Composable
private fun OnboardingImage(
    modifier: Modifier,
    resourceId: Int,
    rotateImage: Float? = null,
    contentScale: ContentScale
){
    val imageModifier =
        if (rotateImage != null) Modifier.rotate(degrees = rotateImage)
        else Modifier

    Box(modifier = modifier
        .padding(top = 16.dp, bottom = 16.dp)
        .height(412.dp)
        .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = imageModifier
                .fillMaxHeight()
                .width(350.dp)
                .padding(horizontal = 14.dp),
            contentScale = contentScale,
            painter = painterResource(id = resourceId),
            contentDescription = null
        )
    }
}

@Composable
private fun OnboardingHeader(
    modifier: Modifier,
    text: String
){
    Text(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
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
    val styledMessage = stringResource(id = onboarding.message)
        .styledText(
            normalSpanStyle = SpanStyle().setStyle(color = White, textStyle = Typography.subtitle2),
            primarySpanStyle = SpanStyle().setStyle(color = White, textStyle = Typography.subtitle1),
            primaryColorText = onboarding.boldText
        )

    Text(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp),
        text = styledMessage,
        color = White,
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