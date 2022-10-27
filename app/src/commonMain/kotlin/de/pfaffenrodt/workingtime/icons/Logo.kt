package de.pfaffenrodt.workingtime.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val IconPack.Logo: ImageVector
    get() {
        if (logo != null) {
            return logo!!
        }
        logo = Builder(name = "Logo", defaultWidth = 1024.0.dp, defaultHeight = 1024.0.dp,
                viewportWidth = 1024.0f, viewportHeight = 1024.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(523.62f, 48.39f)
                horizontalLineToRelative(-13.25f)
                curveToRelative(-7.12f, 1.11f, -12.25f, 5.36f, -17.42f, 10.12f)
                curveToRelative(-37.94f, 34.96f, -75.28f, 70.56f, -113.14f, 105.61f)
                curveToRelative(-19.23f, 17.81f, -38.25f, 35.85f, -57.37f, 53.79f)
                curveToRelative(-32.19f, 30.21f, -64.33f, 60.47f, -96.66f, 90.52f)
                curveToRelative(-19.0f, 17.65f, -37.94f, 35.39f, -56.67f, 53.32f)
                curveToRelative(-12.56f, 12.02f, -25.76f, 23.35f, -37.83f, 35.91f)
                curveToRelative(-20.21f, 21.03f, -25.96f, 50.36f, -14.57f, 77.49f)
                curveToRelative(11.12f, 26.5f, 36.29f, 43.18f, 64.94f, 43.4f)
                curveToRelative(8.96f, 0.07f, 17.66f, -0.83f, 25.9f, -4.4f)
                curveToRelative(4.2f, -1.82f, 5.96f, -1.36f, 5.94f, 3.72f)
                curveToRelative(-0.11f, 45.06f, -0.1f, 90.13f, 0.0f, 135.19f)
                curveToRelative(0.01f, 5.51f, -2.63f, 6.74f, -7.48f, 7.48f)
                curveToRelative(-52.98f, 8.05f, -91.48f, 44.49f, -102.45f, 97.02f)
                curveToRelative(-2.9f, 13.88f, -3.26f, 27.93f, -0.43f, 41.94f)
                curveToRelative(1.38f, 6.86f, 3.84f, 12.81f, 11.78f, 14.22f)
                curveToRelative(12.92f, 0.01f, 17.14f, -3.67f, 16.63f, -16.76f)
                curveToRelative(-0.57f, -14.66f, -1.32f, -29.17f, 3.16f, -43.46f)
                curveToRelative(4.12f, -13.13f, 9.97f, -25.12f, 20.39f, -34.45f)
                curveToRelative(24.65f, -30.97f, 71.36f, -37.42f, 104.17f, -21.88f)
                curveToRelative(28.04f, 13.28f, 45.16f, 35.43f, 51.52f, 65.93f)
                curveToRelative(10.31f, 49.49f, -26.26f, 97.43f, -69.0f, 105.21f)
                curveToRelative(-31.48f, 6.98f, -58.94f, -0.98f, -82.56f, -22.57f)
                curveToRelative(-7.0f, -6.4f, -14.02f, -10.91f, -23.6f, -5.6f)
                curveToRelative(-8.11f, 9.4f, -8.02f, 14.58f, 0.5f, 23.57f)
                curveToRelative(19.38f, 20.46f, 42.95f, 32.21f, 71.16f, 34.28f)
                horizontalLineTo(808.48f)
                curveToRelative(9.48f, -3.82f, 10.52f, -5.46f, 10.53f, -17.88f)
                curveToRelative(0.03f, -99.28f, 0.01f, -198.55f, 0.01f, -297.83f)
                curveToRelative(0.0f, -20.74f, -0.03f, -41.48f, 0.02f, -62.22f)
                curveToRelative(0.02f, -8.13f, 0.2f, -8.25f, 7.81f, -5.55f)
                curveToRelative(43.54f, 15.43f, 93.85f, -11.6f, 95.92f, -67.59f)
                curveToRelative(0.9f, -24.5f, -12.07f, -43.53f, -30.22f, -59.32f)
                curveToRelative(-22.07f, -19.21f, -42.84f, -39.85f, -64.3f, -59.73f)
                curveToRelative(-31.58f, -29.26f, -62.86f, -58.86f, -94.35f, -88.22f)
                curveToRelative(-20.59f, -19.2f, -41.11f, -38.48f, -61.5f, -57.9f)
                curveToRelative(-19.39f, -18.47f, -39.37f, -36.3f, -58.52f, -55.02f)
                curveToRelative(-7.43f, -7.26f, -13.4f, -7.43f, -22.29f, -1.97f)
                curveToRelative(-6.2f, 10.35f, -5.13f, 16.17f, 3.1f, 24.02f)
                curveToRelative(20.57f, 19.62f, 41.45f, 38.91f, 62.18f, 58.35f)
                curveToRelative(31.2f, 29.25f, 62.38f, 58.53f, 93.72f, 87.63f)
                curveToRelative(17.99f, 16.71f, 35.91f, 33.52f, 53.78f, 50.37f)
                curveToRelative(24.1f, 22.71f, 48.03f, 45.61f, 72.64f, 67.77f)
                curveToRelative(13.22f, 11.9f, 19.03f, 26.64f, 15.01f, 43.99f)
                curveToRelative(-3.61f, 15.61f, -13.63f, 26.6f, -29.26f, 31.0f)
                curveToRelative(-15.13f, 4.26f, -29.35f, 1.26f, -40.61f, -9.98f)
                curveToRelative(-11.93f, -11.91f, -24.94f, -22.63f, -36.68f, -34.73f)
                curveToRelative(-27.88f, -28.75f, -57.25f, -55.99f, -85.85f, -84.01f)
                curveToRelative(-35.49f, -34.77f, -71.17f, -69.38f, -106.97f, -103.84f)
                curveToRelative(-17.51f, -16.85f, -34.63f, -34.08f, -52.13f, -50.93f)
                curveToRelative(-16.57f, -15.95f, -31.25f, -15.85f, -47.48f, 0.41f)
                curveToRelative(-25.56f, 25.6f, -51.8f, 50.51f, -77.68f, 75.77f)
                curveToRelative(-36.16f, 35.28f, -72.39f, 70.49f, -108.67f, 105.65f)
                curveToRelative(-30.93f, 29.97f, -61.97f, 59.81f, -92.78f, 89.9f)
                curveToRelative(-16.2f, 15.82f, -37.49f, 17.8f, -56.69f, 5.39f)
                curveToRelative(-21.13f, -16.88f, -23.42f, -45.84f, -4.14f, -64.64f)
                curveToRelative(22.29f, -21.74f, 45.06f, -43.0f, 68.18f, -63.88f)
                curveToRelative(9.61f, -8.68f, 18.96f, -17.68f, 28.29f, -26.65f)
                curveToRelative(30.39f, -29.26f, 61.49f, -57.75f, 92.15f, -86.72f)
                curveToRelative(33.25f, -31.42f, 66.71f, -62.64f, 100.17f, -93.84f)
                curveToRelative(23.18f, -21.62f, 46.27f, -43.34f, 69.46f, -64.95f)
                curveToRelative(4.04f, -3.76f, 7.24f, -4.43f, 11.13f, -0.17f)
                curveToRelative(2.79f, 3.05f, 5.81f, 5.89f, 8.68f, 8.89f)
                curveToRelative(4.85f, 5.24f, 10.46f, 9.62f, 15.87f, 14.22f)
                curveToRelative(8.78f, 7.47f, 11.78f, 7.74f, 21.81f, 1.65f)
                curveToRelative(5.88f, -9.47f, 5.9f, -14.59f, -1.63f, -21.9f)
                curveToRelative(-10.01f, -9.72f, -20.51f, -18.94f, -30.5f, -28.69f)
                curveToRelative(-3.63f, -3.54f, -8.45f, -4.81f, -13.05f, -6.47f)
                close()
            }
            path(fill = SolidColor(Color(0xFFe3eaee)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(261.98f, 668.59f)
                curveToRelative(30.39f, 12.37f, 53.46f, 32.69f, 67.02f, 62.93f)
                curveToRelative(21.09f, 47.07f, 9.73f, 100.91f, -28.32f, 135.65f)
                curveToRelative(-1.73f, 1.58f, -3.46f, 3.16f, -6.5f, 5.93f)
                curveToRelative(27.5f, 0.0f, 53.32f, -0.07f, 79.13f, 0.07f)
                curveToRelative(4.03f, 0.02f, 4.35f, -1.94f, 4.32f, -5.11f)
                curveToRelative(-0.11f, -11.89f, 0.51f, -23.81f, -0.14f, -35.67f)
                curveToRelative(-2.57f, -46.55f, 10.02f, -87.37f, 44.18f, -119.69f)
                curveToRelative(0.15f, -2.51f, -1.66f, -2.61f, -2.6f, -3.24f)
                curveToRelative(-28.77f, -19.3f, -43.56f, -46.43f, -43.84f, -80.92f)
                curveToRelative(-0.42f, -52.81f, -0.61f, -105.64f, 0.0f, -158.45f)
                curveToRelative(0.89f, -76.78f, 59.77f, -133.98f, 136.35f, -134.93f)
                curveToRelative(37.63f, -0.47f, 71.64f, 7.87f, 100.27f, 33.11f)
                curveToRelative(29.93f, 26.38f, 45.9f, 59.67f, 46.16f, 99.78f)
                curveToRelative(0.35f, 53.92f, 0.3f, 107.85f, 0.04f, 161.77f)
                curveToRelative(-0.16f, 33.4f, -14.79f, 59.49f, -42.02f, 78.36f)
                curveToRelative(-4.54f, 3.14f, -4.54f, 4.29f, -0.8f, 8.08f)
                curveToRelative(27.49f, 27.89f, 40.94f, 61.62f, 40.85f, 100.8f)
                curveToRelative(-0.04f, 16.87f, 0.13f, 33.74f, -0.1f, 50.6f)
                curveToRelative(-0.06f, 4.31f, 1.12f, 5.56f, 5.49f, 5.54f)
                curveToRelative(41.67f, -0.16f, 83.35f, -0.18f, 125.03f, 0.02f)
                curveToRelative(4.91f, 0.02f, 5.78f, -1.62f, 5.78f, -6.11f)
                curveToRelative(-0.11f, -124.99f, -0.1f, -249.98f, -0.03f, -374.98f)
                curveToRelative(0.0f, -3.55f, -0.85f, -6.17f, -3.49f, -8.73f)
                curveToRelative(-85.27f, -82.7f, -170.46f, -165.48f, -255.67f, -248.23f)
                curveToRelative(-0.38f, -0.37f, -0.92f, -0.58f, -1.38f, -0.86f)
                curveToRelative(-4.05f, -2.43f, -6.28f, 0.91f, -8.35f, 3.11f)
                curveToRelative(-11.92f, 12.7f, -25.62f, 23.52f, -37.75f, 35.98f)
                curveToRelative(-28.32f, 29.08f, -58.05f, 56.71f, -87.01f, 85.13f)
                curveToRelative(-35.25f, 34.6f, -71.13f, 68.56f, -106.24f, 103.33f)
                curveToRelative(-8.61f, 8.53f, -17.95f, 16.33f, -26.49f, 24.98f)
                curveToRelative(-4.14f, 4.2f, -6.15f, 8.79f, -6.14f, 14.75f)
                curveToRelative(0.09f, 52.52f, 0.05f, 105.04f, 0.07f, 157.56f)
                curveToRelative(0.0f, 3.3f, -0.23f, 6.69f, 2.19f, 9.45f)
                close()
            }
            path(fill = SolidColor(Color(0xFF5de0c3)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(591.77f, 126.66f)
                curveToRelative(-7.95f, -7.41f, -15.91f, -14.82f, -23.86f, -22.23f)
                curveToRelative(-7.6f, 5.16f, -14.21f, 4.02f, -20.57f, -2.54f)
                curveToRelative(-4.77f, -4.92f, -10.19f, -9.2f, -15.32f, -13.77f)
                curveToRelative(-5.56f, 2.14f, -9.71f, 6.38f, -13.75f, 10.35f)
                curveToRelative(-21.44f, 21.12f, -43.66f, 41.42f, -65.68f, 61.89f)
                curveToRelative(-28.7f, 26.67f, -57.06f, 53.7f, -85.92f, 80.2f)
                curveToRelative(-19.1f, 17.53f, -37.86f, 35.46f, -56.78f, 53.22f)
                curveToRelative(-32.4f, 30.4f, -64.82f, 60.77f, -97.24f, 91.15f)
                curveToRelative(-15.3f, 14.34f, -31.15f, 28.13f, -45.49f, 43.5f)
                curveToRelative(-14.21f, 15.21f, -19.15f, 38.9f, -11.15f, 54.26f)
                curveToRelative(17.79f, 13.76f, 41.34f, 12.06f, 58.62f, -4.63f)
                curveToRelative(35.56f, -34.34f, 70.96f, -68.84f, 106.42f, -103.29f)
                curveToRelative(58.43f, -56.77f, 116.85f, -113.55f, 175.28f, -170.32f)
                curveToRelative(13.9f, -13.51f, 26.93f, -13.49f, 41.09f, 0.26f)
                curveToRelative(93.13f, 90.41f, 186.26f, 180.82f, 279.3f, 271.32f)
                curveToRelative(8.58f, 8.35f, 18.0f, 14.58f, 30.21f, 15.45f)
                curveToRelative(20.23f, 1.45f, 36.67f, -8.29f, 44.6f, -26.25f)
                curveToRelative(8.01f, -18.15f, 4.12f, -37.04f, -11.11f, -51.36f)
                curveToRelative(-43.05f, -40.48f, -86.24f, -80.82f, -129.37f, -121.22f)
                curveToRelative(-51.79f, -48.52f, -103.52f, -97.11f, -155.45f, -145.49f)
                curveToRelative(-6.69f, -6.23f, -8.35f, -12.57f, -3.84f, -20.49f)
                close()
            }
            path(fill = SolidColor(Color(0xFFfc9368)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(422.63f, 872.83f)
                curveToRelative(60.16f, 0.09f, 120.32f, 0.19f, 180.49f, 0.28f)
                curveToRelative(7.73f, 0.01f, 15.46f, 0.0f, 23.18f, 0.0f)
                curveToRelative(2.48f, 0.0f, 5.1f, 0.4f, 4.95f, -3.53f)
                curveToRelative(-1.06f, -27.56f, 3.32f, -55.47f, -3.56f, -82.63f)
                curveToRelative(-8.93f, -35.27f, -30.43f, -60.72f, -63.25f, -76.4f)
                curveToRelative(-2.78f, -1.33f, -5.78f, -4.51f, -8.07f, 1.81f)
                curveToRelative(-6.59f, 18.18f, -19.85f, 28.46f, -39.39f, 28.56f)
                curveToRelative(-19.95f, 0.1f, -32.95f, -10.63f, -40.24f, -28.82f)
                curveToRelative(-4.51f, -2.16f, -7.33f, 1.03f, -10.13f, 3.49f)
                curveToRelative(-30.24f, 26.68f, -45.81f, 60.21f, -46.3f, 100.62f)
                curveToRelative(-0.19f, 15.47f, -0.07f, 30.94f, 0.0f, 46.41f)
                curveToRelative(0.02f, 3.54f, -0.49f, 7.27f, 2.32f, 10.2f)
                close()
            }
            path(fill = SolidColor(Color(0xFFfecdbe)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(467.17f, 642.85f)
                curveToRelative(54.9f, 31.95f, 130.4f, 2.0f, 152.42f, -60.27f)
                curveToRelative(7.38f, -20.88f, 6.18f, -42.45f, 6.31f, -63.97f)
                curveToRelative(0.02f, -2.71f, -1.47f, -4.01f, -3.5f, -5.04f)
                curveToRelative(-27.02f, -13.72f, -45.2f, -35.6f, -57.72f, -62.71f)
                curveToRelative(-0.34f, -0.74f, -0.86f, -1.4f, -1.38f, -2.24f)
                curveToRelative(-38.23f, 43.41f, -87.27f, 64.14f, -142.35f, 72.97f)
                curveToRelative(-1.69f, 1.67f, -2.02f, 3.82f, -2.18f, 6.06f)
                curveToRelative(-2.66f, 36.56f, 4.92f, 70.05f, 29.08f, 98.73f)
                curveToRelative(5.57f, 6.61f, 12.63f, 11.28f, 19.32f, 16.47f)
                close()
            }
            path(fill = SolidColor(Color(0xFFfdcd84)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(242.62f, 870.02f)
                curveToRelative(30.95f, -4.42f, 60.78f, -33.82f, 69.18f, -68.15f)
                curveToRelative(9.35f, -38.24f, -6.3f, -78.19f, -39.09f, -99.81f)
                curveToRelative(-32.85f, -21.65f, -75.6f, -20.32f, -106.99f, 3.2f)
                curveToRelative(-4.46f, 3.34f, -8.16f, 7.28f, -11.4f, 11.74f)
                curveToRelative(-21.06f, 36.63f, -14.2f, 87.82f, 16.28f, 119.95f)
                curveToRelative(18.08f, 19.06f, 39.56f, 31.59f, 66.31f, 33.57f)
                curveToRelative(1.92f, 0.14f, 3.86f, 0.27f, 5.72f, -0.5f)
                close()
            }
            path(fill = SolidColor(Color(0xFF685e68)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(424.59f, 494.99f)
                curveToRelative(47.12f, -7.57f, 88.49f, -26.06f, 119.89f, -63.43f)
                curveToRelative(3.75f, -4.46f, 6.49f, -9.59f, 8.84f, -14.9f)
                curveToRelative(2.2f, -4.98f, 5.77f, -8.06f, 11.37f, -8.13f)
                curveToRelative(5.97f, -0.07f, 9.7f, 3.23f, 12.05f, 8.44f)
                curveToRelative(7.72f, 17.07f, 14.43f, 34.65f, 26.3f, 49.54f)
                curveToRelative(6.98f, 8.76f, 15.27f, 15.87f, 24.82f, 21.59f)
                curveToRelative(2.59f, 1.55f, 4.9f, 2.88f, 5.35f, -2.14f)
                curveToRelative(5.8f, -65.09f, -33.68f, -111.83f, -85.87f, -123.05f)
                curveToRelative(-22.63f, -4.87f, -45.88f, -5.15f, -68.49f, 2.27f)
                curveToRelative(-21.92f, 9.38f, -35.39f, 27.34f, -46.47f, 47.23f)
                curveToRelative(-13.35f, 23.96f, -15.18f, 50.26f, -13.49f, 77.01f)
                curveToRelative(0.21f, 3.25f, 0.53f, 7.07f, 5.69f, 5.57f)
                close()
            }
            path(fill = SolidColor(Color(0xFF0ed1b2)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(156.01f, 482.67f)
                curveToRelative(-3.87f, -18.13f, -2.11f, -35.38f, 10.08f, -49.99f)
                curveToRelative(7.05f, -8.45f, 15.3f, -15.93f, 23.34f, -23.5f)
                curveToRelative(23.87f, -22.49f, 47.93f, -44.77f, 71.86f, -67.19f)
                curveToRelative(35.6f, -33.36f, 71.13f, -66.79f, 106.71f, -100.17f)
                curveToRelative(25.33f, -23.76f, 50.63f, -47.54f, 76.05f, -71.2f)
                curveToRelative(27.83f, -25.9f, 55.79f, -51.67f, 83.66f, -77.53f)
                curveToRelative(1.6f, -1.48f, 2.89f, -3.3f, 4.33f, -4.97f)
                curveToRelative(-0.11f, -0.25f, -0.16f, -0.56f, -0.34f, -0.75f)
                quadToRelative(-14.13f, -15.02f, -28.85f, -1.12f)
                curveToRelative(-113.26f, 106.1f, -226.53f, 212.17f, -339.8f, 318.25f)
                curveToRelative(-10.25f, 9.6f, -21.55f, 18.42f, -24.03f, 33.63f)
                curveToRelative(-2.97f, 18.19f, 2.32f, 33.16f, 17.01f, 44.56f)
                close()
            }
            path(fill = SolidColor(Color(0xFFcfd8dc)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(261.98f, 668.59f)
                curveToRelative(-0.01f, -55.78f, 0.05f, -111.57f, -0.16f, -167.35f)
                curveToRelative(-0.02f, -5.51f, 1.73f, -9.35f, 5.66f, -12.94f)
                curveToRelative(23.39f, -21.39f, 45.04f, -44.62f, 68.23f, -66.18f)
                curveToRelative(17.58f, -16.34f, 34.0f, -33.8f, 51.42f, -50.26f)
                curveToRelative(37.45f, -35.38f, 74.19f, -71.5f, 111.0f, -107.54f)
                curveToRelative(9.02f, -8.83f, 18.31f, -17.48f, 27.44f, -26.24f)
                curveToRelative(1.77f, -1.7f, 3.3f, -3.81f, 6.13f, -3.77f)
                quadToRelative(-14.34f, -15.71f, -29.43f, -1.01f)
                curveToRelative(-84.97f, 82.55f, -169.92f, 165.11f, -255.0f, 247.54f)
                curveToRelative(-4.28f, 4.14f, -6.32f, 8.13f, -6.29f, 14.27f)
                curveToRelative(0.26f, 53.07f, 0.27f, 106.15f, 0.0f, 159.22f)
                curveToRelative(-0.03f, 6.52f, 1.09f, 10.26f, 8.26f, 10.97f)
                curveToRelative(4.31f, 0.42f, 8.49f, 2.15f, 12.73f, 3.29f)
                close()
            }
            path(fill = SolidColor(Color(0xFFfbba65)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(242.62f, 870.02f)
                curveToRelative(-47.62f, -4.63f, -84.36f, -36.43f, -95.64f, -82.85f)
                curveToRelative(-5.18f, -21.32f, -2.74f, -42.06f, 5.16f, -62.3f)
                curveToRelative(1.0f, -2.57f, 2.44f, -4.97f, 2.17f, -7.88f)
                curveToRelative(-15.25f, 12.98f, -21.36f, 30.57f, -24.84f, 49.48f)
                curveToRelative(-1.77f, 9.61f, -0.88f, 19.21f, 0.16f, 28.82f)
                curveToRelative(1.31f, 12.14f, -1.87f, 15.91f, -14.01f, 16.98f)
                curveToRelative(4.25f, 0.8f, 6.48f, 3.19f, 8.12f, 7.42f)
                curveToRelative(3.02f, 7.83f, 6.76f, 15.43f, 12.27f, 21.95f)
                curveToRelative(7.7f, -4.08f, 13.64f, -1.92f, 19.84f, 3.96f)
                curveToRelative(24.55f, 23.28f, 53.23f, 32.78f, 86.77f, 24.4f)
                close()
            }
            path(fill = SolidColor(Color(0xFFfd7c43)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(422.63f, 872.83f)
                curveToRelative(0.0f, -20.15f, -0.53f, -40.32f, 0.09f, -60.46f)
                curveToRelative(1.2f, -39.38f, 17.84f, -71.48f, 47.44f, -97.03f)
                curveToRelative(1.79f, -1.55f, 4.37f, -2.18f, 6.58f, -3.24f)
                curveToRelative(-1.12f, -6.14f, -4.68f, -2.99f, -7.31f, -1.72f)
                curveToRelative(-35.1f, 16.89f, -57.35f, 44.3f, -64.82f, 82.61f)
                curveToRelative(-4.88f, 25.09f, -1.33f, 50.71f, -2.18f, 76.07f)
                curveToRelative(-0.11f, 3.43f, 1.53f, 4.19f, 4.51f, 4.08f)
                curveToRelative(5.23f, -0.2f, 10.46f, -0.22f, 15.7f, -0.31f)
                close()
            }
            path(fill = SolidColor(Color(0xFF554e56)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(424.59f, 494.99f)
                curveToRelative(-3.16f, -0.48f, -3.65f, -2.65f, -3.68f, -5.41f)
                curveToRelative(-0.31f, -22.82f, -0.33f, -45.38f, 9.27f, -67.05f)
                curveToRelative(10.34f, -23.33f, 25.6f, -41.93f, 47.01f, -55.59f)
                curveToRelative(0.66f, -0.42f, 1.12f, -1.16f, 1.68f, -1.75f)
                curveToRelative(-34.44f, 9.68f, -57.51f, 32.06f, -71.21f, 64.58f)
                curveToRelative(-8.55f, 20.31f, -8.24f, 41.88f, -8.02f, 63.38f)
                curveToRelative(0.03f, 3.42f, 1.15f, 5.35f, 4.78f, 4.83f)
                curveToRelative(6.73f, -0.96f, 13.64f, -0.71f, 20.18f, -2.99f)
                close()
            }
            path(fill = SolidColor(Color(0xFF554e56)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(632.03f, 615.14f)
                curveToRelative(-7.55f, 10.39f, -15.08f, 20.37f, -24.26f, 29.07f)
                curveToRelative(-12.84f, 12.16f, -27.71f, 20.8f, -43.84f, 27.5f)
                curveToRelative(-2.95f, 1.22f, -5.41f, 2.03f, -5.53f, 6.04f)
                curveToRelative(-0.13f, 4.4f, 3.16f, 4.56f, 5.78f, 5.74f)
                curveToRelative(6.02f, 2.72f, 12.27f, 5.02f, 17.99f, 8.26f)
                curveToRelative(4.97f, 2.82f, 9.22f, 2.54f, 13.91f, -0.23f)
                curveToRelative(22.73f, -13.43f, 36.09f, -32.65f, 36.99f, -59.63f)
                curveToRelative(0.17f, -4.96f, 0.04f, -9.94f, -0.01f, -14.91f)
                curveToRelative(0.0f, -0.42f, -0.44f, -0.83f, -1.02f, -1.84f)
                close()
            }
            path(fill = SolidColor(Color(0xFF423f42)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(424.34f, 643.68f)
                curveToRelative(-8.49f, -9.33f, -16.65f, -18.94f, -23.4f, -30.17f)
                curveToRelative(-5.8f, 34.24f, 10.8f, 66.89f, 41.23f, 80.23f)
                curveToRelative(4.41f, 1.93f, 7.22f, -0.84f, 10.26f, -3.15f)
                curveToRelative(-13.54f, -13.12f, -21.7f, -29.48f, -28.09f, -46.91f)
                close()
            }
            path(fill = SolidColor(Color(0xFFfdaf9d)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(467.17f, 642.85f)
                curveToRelative(-6.63f, -7.54f, -14.58f, -13.73f, -20.73f, -21.87f)
                curveToRelative(-15.48f, -20.48f, -24.48f, -43.18f, -25.45f, -68.87f)
                curveToRelative(-0.38f, -10.16f, -0.05f, -20.34f, -0.05f, -30.51f)
                curveToRelative(-2.19f, 0.15f, -4.38f, 0.41f, -6.57f, 0.42f)
                curveToRelative(-4.95f, 0.02f, -6.83f, 1.85f, -6.82f, 7.34f)
                curveToRelative(0.06f, 18.27f, 0.05f, 36.45f, 6.72f, 53.85f)
                curveToRelative(10.17f, 26.52f, 27.11f, 47.01f, 52.89f, 59.64f)
                close()
            }
            path(fill = SolidColor(Color(0xFFfea68e)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(500.11f, 692.27f)
                curveToRelative(0.0f, 3.04f, -0.3f, 6.11f, 0.06f, 9.11f)
                curveToRelative(1.06f, 8.89f, 8.17f, 14.93f, 17.0f, 14.73f)
                curveToRelative(8.77f, -0.2f, 15.79f, -6.58f, 16.35f, -15.49f)
                curveToRelative(0.4f, -6.33f, 2.19f, -13.86f, -0.47f, -18.78f)
                curveToRelative(-3.32f, -6.14f, -11.22f, 0.21f, -17.01f, -1.4f)
                curveToRelative(-1.29f, -0.36f, -2.75f, -0.12f, -4.12f, -0.18f)
                quadToRelative(-12.1f, -0.52f, -11.81f, 12.01f)
                close()
            }
            path(fill = SolidColor(Color(0xFF544d55)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(424.34f, 643.68f)
                curveToRelative(3.52f, 19.15f, 11.55f, 35.58f, 28.09f, 46.91f)
                curveToRelative(6.1f, -2.53f, 12.17f, -5.14f, 18.32f, -7.56f)
                curveToRelative(2.86f, -1.12f, 4.68f, -2.68f, 4.52f, -6.04f)
                curveToRelative(-0.15f, -3.09f, -2.08f, -4.07f, -4.64f, -4.96f)
                curveToRelative(-17.48f, -6.07f, -32.21f, -16.68f, -46.28f, -28.35f)
                close()
            }
            path(fill = SolidColor(Color(0xFF010100)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(573.89f, 798.71f)
                curveToRelative(4.41f, 0.0f, 8.83f, 0.22f, 13.22f, -0.04f)
                curveToRelative(7.2f, -0.43f, 11.2f, -4.88f, 11.6f, -11.67f)
                curveToRelative(0.38f, -6.51f, -3.28f, -11.5f, -9.8f, -12.42f)
                curveToRelative(-10.08f, -1.43f, -20.38f, -1.32f, -30.47f, -0.07f)
                curveToRelative(-6.49f, 0.8f, -10.27f, 5.77f, -10.0f, 12.29f)
                curveToRelative(0.28f, 6.79f, 4.17f, 11.38f, 11.39f, 11.85f)
                curveToRelative(4.66f, 0.31f, 9.36f, 0.06f, 14.05f, 0.07f)
                close()
            }
            path(fill = SolidColor(Color(0xFF010100)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(550.16f, 555.08f)
                curveToRelative(0.0f, 3.59f, -0.35f, 7.21f, 0.07f, 10.75f)
                curveToRelative(0.85f, 7.03f, 5.32f, 11.08f, 12.15f, 11.15f)
                curveToRelative(6.87f, 0.07f, 11.63f, -4.01f, 12.3f, -10.97f)
                curveToRelative(0.66f, -6.83f, 0.5f, -13.8f, 0.08f, -20.67f)
                curveToRelative(-0.43f, -7.03f, -6.01f, -11.82f, -12.61f, -11.65f)
                curveToRelative(-6.65f, 0.18f, -11.51f, 5.05f, -12.01f, 12.28f)
                curveToRelative(-0.21f, 3.02f, -0.04f, 6.07f, -0.04f, 9.1f)
                horizontalLineToRelative(0.05f)
                close()
            }
            path(fill = SolidColor(Color(0xFF010101)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(458.84f, 555.38f)
                curveToRelative(0.0f, 3.31f, -0.17f, 6.63f, 0.04f, 9.92f)
                curveToRelative(0.45f, 7.2f, 4.77f, 11.25f, 11.58f, 11.65f)
                curveToRelative(6.93f, 0.41f, 11.91f, -3.6f, 12.7f, -10.44f)
                curveToRelative(0.84f, -7.34f, 0.85f, -14.92f, 0.0f, -22.26f)
                curveToRelative(-0.79f, -6.83f, -5.7f, -10.81f, -12.7f, -10.41f)
                curveToRelative(-6.89f, 0.39f, -11.1f, 4.44f, -11.57f, 11.61f)
                curveToRelative(-0.22f, 3.29f, -0.04f, 6.61f, -0.04f, 9.92f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(233.86f, 748.88f)
                curveToRelative(0.0f, -8.3f, 0.03f, -16.59f, 0.0f, -24.89f)
                curveToRelative(-0.04f, -10.46f, -4.39f, -16.29f, -12.18f, -16.41f)
                curveToRelative(-7.81f, -0.13f, -12.6f, 5.89f, -12.64f, 16.08f)
                curveToRelative(-0.06f, 13.83f, -0.44f, 27.67f, 0.17f, 41.47f)
                curveToRelative(0.3f, 6.67f, -2.02f, 10.81f, -7.28f, 14.25f)
                curveToRelative(-3.91f, 2.56f, -7.61f, 5.52f, -11.11f, 8.62f)
                curveToRelative(-5.57f, 4.94f, -6.35f, 11.59f, -2.35f, 17.03f)
                curveToRelative(4.17f, 5.67f, 11.29f, 6.86f, 17.58f, 2.33f)
                curveToRelative(7.61f, -5.48f, 14.88f, -11.43f, 22.31f, -17.17f)
                curveToRelative(4.03f, -3.11f, 5.65f, -7.18f, 5.55f, -12.28f)
                curveToRelative(-0.18f, -9.68f, -0.05f, -19.36f, -0.05f, -29.04f)
                close()
            }
        }
        .build()
        return logo!!
    }

private var logo: ImageVector? = null