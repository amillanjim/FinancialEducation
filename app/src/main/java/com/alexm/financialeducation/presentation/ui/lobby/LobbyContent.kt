package com.alexm.financialeducation.presentation.ui.lobby

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.alexm.financialeducation.R
import com.alexm.financialeducation.presentation.ui.compose.basecomponents.IconText
import com.alexm.financialeducation.presentation.ui.compose.basecomponents.OutlinedBox
import com.alexm.financialeducation.presentation.ui.compose.basecomponents.Toolbar
import com.alexm.financialeducation.presentation.ui.compose.theme.*
import com.alexm.financialeducation.data.dto.Lobby
import com.alexm.financialeducation.presentation.ui.lobby.components.GradientCircularProgressBar
import com.alexm.financialeducation.presentation.viewmodel.FinancialEducationViewModel

@Composable
fun LobbyContent(
    viewModel: FinancialEducationViewModel,
    onBackPressed: () -> Unit,
    onSectionSelected: () -> Unit,
    onNextChallengeClick: () -> Unit = {}
) {
    val lobbyState by viewModel.lobbyState.collectAsState()
    val completedSections by viewModel.completedSections.collectAsState()

    Scaffold(
        modifier = Modifier.statusBarsPadding(),
        topBar = { TopBar{ onBackPressed.invoke() } },
        backgroundColor = Light
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            LobbyHeader(headerResource = R.string.fe_lobby_header)
            Spacer(modifier = Modifier.height(24.dp))
            LobbyCard(
                completedSections = completedSections,
                lobby = lobbyState.lobby,
                onSectionSelected = onSectionSelected
            )
            Spacer(modifier = Modifier.height(16.dp))
            LobbyHeader(headerResource = R.string.fe_lobby_subheader)
            Spacer(modifier = Modifier.height(24.dp))
            LobbyNextChallengeFD(onClick = onNextChallengeClick)
        }
    }
}

@Composable
private fun TopBar(
    onBackPressed: () -> Unit
){
    Toolbar(
        text = stringResource(id = R.string.fe_toolbar_header),
        leftIconResource = R.drawable.ic_chevron_left_24px,
        iconTint = Stori700Primary,
        onLeftClick = onBackPressed
    )
}

@Composable
private fun LobbyHeader(
    headerResource: Int
){
    Text(
        text = stringResource(id = headerResource),
        style = Typography.h3
    )
}

@Composable
private fun LobbyCard(
    lobby: Lobby,
    completedSections: Int,
    onSectionSelected: () -> Unit
){
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(28.dp))
            LobbyProgressHeader(completedSections = completedSections, lobby = lobby)
            Spacer(modifier = Modifier.height(18.dp))
            LobbySection(
                stringResource = R.string.fe_first_section_educative_question,
                completedSections = completedSections,
                position = 1,
                onSectionSelected = onSectionSelected
            )
            Spacer(modifier = Modifier.height(10.dp))
            LobbySection(
                stringResource = R.string.fe_second_section_educative_question,
                completedSections = completedSections,
                position = 2,
                onSectionSelected = onSectionSelected
            )
            Spacer(modifier = Modifier.height(10.dp))
            LobbySection(
                stringResource = R.string.fe_third_section_educative_question,
                completedSections = completedSections,
                position = 3,
                onSectionSelected = onSectionSelected
            )
            Spacer(modifier = Modifier.height(10.dp))
            LobbySection(
                stringResource = R.string.fe_fourth_section_educative_question,
                completedSections = completedSections,
                position = 4,
                onSectionSelected = onSectionSelected
            )
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
private fun LobbyProgressHeader(
    completedSections: Int,
    lobby: Lobby
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(7.dp)
    ) {
        GradientCircularProgressBar(completedSections = completedSections)
        ProgressMessage(lobby = lobby)
    }
}

@Composable
private fun ProgressMessage(lobby: Lobby){
    Column(modifier = Modifier.fillMaxWidth()) {
        IconText(
            text = stringResource(lobby.title),
            textStyle = Typography.subtitle3(),
            resource = lobby.emojiResource,
            isIcon = false
        )

        Text(
            text = stringResource(lobby.subtitle),
            color = Gray700,
            style = Typography.caption
        )
    }
}

@Composable
private fun LobbySection(
    stringResource: Int,
    completedSections: Int,
    position: Int,
    onSectionSelected: () -> Unit
){
    val isCompleted = position <= completedSections
    val isSelectable = position == completedSections + 1

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = Shapes.medium,
        elevation = 0.dp,
        backgroundColor = if (isCompleted) Stori50 else Gray50
    ) {
        val rowModifier = if (isSelectable) {
            Modifier
                .clickable(onClick = onSectionSelected)
                .padding(all = 12.dp)
        } else {
            Modifier.padding(all = 12.dp)
        }

        Row(
            modifier = rowModifier
        ) {
            IconText(
                modifier = Modifier
                    .weight(10F)
                    .padding(end = 8.dp),
                text = stringResource(id = stringResource),
                textStyle = Typography.caption,
                textColor = if (isCompleted) Stori700Primary else GrayBlack,
                resource = if (isCompleted) R.drawable.ic_checkmark_on_green_24px
                else R.drawable.ic_checkmark_off_24px,
                isIcon = false
            )

            if (isSelectable) {
                Icon(
                    modifier = Modifier
                        .weight(1F)
                        .align(Alignment.CenterVertically)
                        .size(25.dp),
                    painter = painterResource(id = R.drawable.ic_chevron_right_24px),
                    contentDescription = null
                )
            } else {
                Spacer(modifier = Modifier
                    .width(25.dp)
                    .weight(1F))
            }
        }
    }
}

@Composable
private fun LobbyNextChallengeFD(
    onClick: () -> Unit
){
    OutlinedBox(modifier = Modifier
        .fillMaxWidth(),
        backgroundColor = White,
        borderColor = Info,
        elevation = 0.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = onClick)
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                modifier = Modifier
                    .height(55.dp)
                    .width(55.dp),
                painter = painterResource(id = R.drawable.img_book_keep_moving_no_light),
                contentDescription = null
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .align(alignment = Alignment.CenterVertically),
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.fe_lobby_next_challenge),
                    style = Typography.subtitle3()
                )
                Text(
                    text = stringResource(id = R.string.fe_lobby_learn_more_about_your_card),
                    color = Gray700,
                    style = Typography.caption
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {
                Icon(
                    modifier = Modifier
                        .align(alignment = Alignment.CenterEnd)
                        .size(25.dp),
                    painter = painterResource(id = R.drawable.ic_chevron_right_24px),
                    contentDescription = null
                )
            }
        }
    }
}